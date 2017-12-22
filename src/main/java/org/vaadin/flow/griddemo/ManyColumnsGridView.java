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

import java.util.stream.IntStream;

import com.vaadin.router.Route;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.grid.Grid;
import com.vaadin.ui.layout.VerticalLayout;

/**
 * The main view contains a button and a template element.
 */
@HtmlImport("styles.html")
@Route("many-columns")
public class ManyColumnsGridView extends VerticalLayout {

    private static class Item {

        private int row;

        public Item(int row) {
            this.row = row;
        }

        public String get(int col) {
            return "(" + col + "," + row + ")";
        }
    }

    private Grid<Item> grid;

    public ManyColumnsGridView() {
        grid = new Grid<>();

        // Columns
        IntStream.rangeClosed(1, 52).forEach(
                i -> grid.addColumn(item -> item.get(i))
                        .setHeader("Week " + i));

        // Data
        grid.setItems(IntStream.range(1, 400).mapToObj(Item::new));

        // Size
        grid.setWidth("100%");

        add(grid);
    }
}
