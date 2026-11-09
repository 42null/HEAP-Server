package com.example.api.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

    enum ProgressStatus {
        UNSET((byte) 0, "#D3D3D3"),
        BACKLOG((byte) 1, "#808080"),
        SELECTED((byte) 2, "#0000FF"),
        IN_PROGRESS((byte) 3, "#FFA500"),
        COMPLETED((byte) 4, "#008000"),
        ARCHIVED((byte) 99, "#A9A9A9");

        private final byte order; //Order is bnot used in a custom compare-to but is make to match the client and to make additions easier
        private final String hexColor;

        ProgressStatus(byte order, String hexColor) {
            this.order = order;
            this.hexColor = hexColor;
        }

        public int getOrder() {
            return order;
        }

        public String getHexColor() {
            return hexColor;
        }

    }

    // Tracking of connected systems
    int uncommitedItemId = -1;

    // Item values
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String title;
    short priority = -1;
    ProgressStatus progressStatus = ProgressStatus.UNSET;


    Item(){

    }

    Item(String title, short priority, ProgressStatus progressStatus){
        this.title = title;
        this.priority = priority;
        this.progressStatus = progressStatus;
    }



}