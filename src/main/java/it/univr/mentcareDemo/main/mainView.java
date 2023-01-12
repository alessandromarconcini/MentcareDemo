package it.univr.mentcareDemo.main;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import it.univr.mentcareDemo.model.User;
import it.univr.mentcareDemo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Route("/home")
public class mainView extends VerticalLayout {

    private Grid<User> userGrid;

    private UserRepository userRepository;

    public mainView(UserRepository userRepository){

        //MainLayout
        setPadding(true);
        setMargin(true);
        setWidth("auto");


        add(new Label("Ciao"));
        this.userRepository = userRepository;
        userGrid = new Grid<User>(User.class);

        List<User> userList = new ArrayList<>();

        for(User u:userRepository.findAll())
            userList.add(u);

        userGrid.setItems(userList);
        add(userGrid);

    }
}