package it.univr.mentcareDemo.main;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/login")
public class loginView extends VerticalLayout {

    public loginView() {

        LoginForm loginForm = new LoginForm();
        add(loginForm);
    }
}
