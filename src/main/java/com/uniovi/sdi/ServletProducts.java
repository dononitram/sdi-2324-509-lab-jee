package com.uniovi.sdi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

// ServletProduct

// que obtenga todos los productos de la base de datos
// lo almacene en una variable storeProducts y devuelva al cliente
// la lista de producto

// el servlet deberá transferir la solicitud a una JSP products-view.jsp

// Segundo, añada una nueva opción productos en la barra de navegación
// que llame al servlet products

// Finalmente, crea la vista products-view.jsp que muestre la lista de productso. Dentro de la vista de sebe recorrer
// storeProducts con etiquetas de JSTL

@WebServlet(name = "ServletProducts", value = "/products")
public class ServletProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        HttpSession session = request.getSession();

        List<Product> storeProducts = getProducts();

        request.setAttribute("storeProducts", storeProducts);

        getServletContext().getRequestDispatcher("/products-view.jsp").forward(request, response);


    }

    public List<Product> getProducts() {
        List<Product> products = new LinkedList<Product>();
        ObjectContainer db = null;

        try {
            db = Db4oEmbedded.openFile("bdProducts");
            List<Product> response = db.queryByExample(Product.class);
            // NO RETORNAR LA MISMA LISTA DE LA RESPUESTA
            products.addAll(response);
        } finally {
            db.close();
        }
        return products;
    }

}
