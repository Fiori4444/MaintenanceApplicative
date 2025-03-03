package com.gildedrose;

public class Brie extends Item {

    public static final String AGED_BRIE = "Aged Brie";

    public Brie(int sellIn, int quality){
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    public void update(){
        if (this.quality < 50) {
            this.quality = this.quality + 1;
            if (this.sellIn <= 0) {
                this.quality = this.quality + 1;
            }
        }

        this.sellIn = this.sellIn - 1;
    }
    
}
