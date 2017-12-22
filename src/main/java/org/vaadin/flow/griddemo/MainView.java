/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.flow.griddemo;

import org.vaadin.flow.griddemo.data.Person;
import org.vaadin.flow.griddemo.data.PersonService;

import com.vaadin.router.Route;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.grid.ColumnGroup;
import com.vaadin.ui.grid.Grid;
import com.vaadin.ui.grid.Grid.Column;
import com.vaadin.ui.layout.VerticalLayout;
import com.vaadin.ui.renderers.TemplateRenderer;

/**
 * The main view contains a button and a template element.
 */
@HtmlImport("styles.html")
@Route("")
public class MainView extends VerticalLayout {

    private Grid<Person> grid;

    public MainView() {
        grid = new Grid<>();

        // Columns
        Column<Person> indexColumn = grid
                .addColumn(TemplateRenderer.of("[[index]]")).setHeader("#");
        Column<Person> firstNameColumn = grid.addColumn(Person::getFirstName)
                .setHeader("First name");
        Column<Person> lastNameColumn = grid.addColumn(Person::getLastName)
                .setHeader("Last name");
        Column<Person> streetColumn = grid
                .addColumn(person -> person.getAddress().getStreet())
                .setHeader("Street");
        Column<Person> cityColumn = grid
                .addColumn(person -> person.getAddress().getCity())
                .setHeader("City");
        Column<Person> stateColumn = grid
                .addColumn(person -> person.getAddress().getState())
                .setHeader("State");
        Column<Person> zipColumn = grid
                .addColumn(person -> person.getAddress().getZip())
                .setHeader("Zip");
        Column<Person> countryColumn = grid
                .addColumn(person -> person.getAddress().getCountry())
                .setHeader("Country");
        Column<Person> phoneColumn = grid
                .addColumn(person -> person.getAddress().getPhone())
                .setHeader("Phone");
        Column<Person> emailColumn = grid.addColumn(Person::getEmail)
                .setHeader("Email");

        // Column groups
        ColumnGroup nameGroup = grid
                .mergeColumns(firstNameColumn, lastNameColumn)
                .setHeader("Name");
        ColumnGroup addressGroup = grid
                .mergeColumns(streetColumn, cityColumn, stateColumn, zipColumn,
                        countryColumn).setHeader("Address");
        ColumnGroup contactGroup = grid.mergeColumns(phoneColumn, emailColumn)
                .setHeader("Contact");

        // Data
        grid.setItems(PersonService.getInstance().getAll());

        // Size
        indexColumn.setWidth("60px").setResizable(false).setFrozen(true);
        streetColumn.setWidth("250px");
        cityColumn.setWidth("150px");
        stateColumn.setWidth("150px");
        zipColumn.setWidth("150px");
        phoneColumn.setWidth("200px");
        emailColumn.setWidth("300px");

        nameGroup.setResizable(true);
        addressGroup.setResizable(true);
        contactGroup.setResizable(true);

        grid.setWidth("600px");

        add(grid);
    }
}
