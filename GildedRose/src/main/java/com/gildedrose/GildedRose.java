package com.gildedrose;

class GildedRose {
    // public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    // public static final String AGED_BRIE = "Aged Brie";
    // public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        //handleItems(items[i]);
            items[i].update();
        }
    }

    // private void handleItems(Item item){
    //     if(item.name.equals(SULFURAS_HAND_OF_RAGNAROS)){
    //         handleRagnaros(item);
    //     } else if(item.name.equals(AGED_BRIE)){
    //         handleBrie(item);
    //     } else if(item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)){
    //         handleConcert(item);
    //     } else {
    //         if (item.quality > 0) {
    //             item.quality = item.quality - 1;
    //         } 

    //         item.sellIn = item.sellIn - 1;

    //         if (item.sellIn < 0) {
    //             if (item.quality > 0) {
    //                 item.quality = item.quality - 1;
    //             }
    //         }
    //     }
    // }

    // private void handleBrie(Item item){
    //     if (item.quality < 50) {
    //         item.quality = item.quality + 1;
    //         if (item.sellIn <= 0) {
    //             item.quality = item.quality + 1;
    //         }
    //     }

    //     item.sellIn = item.sellIn - 1;
    // }

    // private void handleConcert(Item item){
    //     if (item.quality < 50) {
    //         item.quality = item.quality + 1;

    //         if (item.sellIn < 11) {
    //             if (item.quality < 50) {
    //                 item.quality = item.quality + 1;
    //             }
    //         }

    //         if (item.sellIn < 6) {
    //             if (item.quality < 50) {
    //                 item.quality = item.quality + 1;
    //             }
    //         }
    //     }

    //     if (item.sellIn == 0){
    //         item.quality = 0;
    //     }
    // }

    // private void handleRagnaros(Item item){}
    

}
