package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        // BEGIN
        PrintWriter printWriter = response.getWriter();
        List<String> resultCompany = new ArrayList<>();
        boolean haveATest = false;
        if (request.getQueryString() != null) {
            for (String company : getCompanies()) {
                if (company.contains(request.getParameter("search"))) {
                    resultCompany.add(company);
                    haveATest = true;
                }
            }
            if (!haveATest) {
                printWriter.write("Companies not found");
                printWriter.close();
            }
            resultCompany.forEach(company -> printWriter.println(company));
            printWriter.close();
        } else {
            getCompanies().forEach(company -> printWriter.println(company));
            printWriter.close();
        }
        // END
    }
}
