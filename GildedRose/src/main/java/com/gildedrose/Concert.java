package com.gildedrose;

public class Concert extends Item {

    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public Concert(int sellIn, int quality){
        super(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT, sellIn, quality);
    }

    @Override
    public void update(){
        if (this.quality < 50) {
            this.quality = this.quality + 1;

            if (this.sellIn < 11) {
                if (this.quality < 50) {
                    this.quality = this.quality + 1;
                }
            }

            if (this.sellIn < 6) {
                if (this.quality < 50) {
                    this.quality = this.quality + 1;
                }
            }
        }

        if (this.sellIn == 0){
            this.quality = 0;
        }
    }
    
}
