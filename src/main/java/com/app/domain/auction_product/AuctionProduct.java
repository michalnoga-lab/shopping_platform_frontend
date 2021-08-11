package com.app.domain.auction_product;

import com.app.domain.auction_product.dto.GetAuctionProductDto;
import lombok.*;

import java.math.BigDecimal;

/**
 * AuctionProduct class
 * Represents exact product from purchaser auction
 * AuctionProduct values don't change during whole application lifetime
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@ToString
public class AuctionProduct {

    /**
     * Product ID
     */
    Long id;

    /**
     * Product name given by purchaser
     */
    String name;

    /**
     * Product description given by purchaser
     */
    String description;

    /**
     * Product index in auction given by purchaser
     */
    String auctionIndex;

    /**
     * Product consecutive number in purchasers products table
     */
    String auctionConsecutiveNumber;

    /**
     * Product nett price from auction
     */
    BigDecimal nettPrice;

    /**
     * Product vat rate from auction
     */
    Integer vat;

    /**
     * Product gross price from auction
     */
    BigDecimal grossPrice;

    /**
     * Product unique EAN code
     */
    String ean;

    /**
     * Converts AuctionProduct to AuctionProductDto
     *
     * @return GetAuctionProductDto
     */
    public GetAuctionProductDto toGetAuctionProductDto() {
        return GetAuctionProductDto
                .builder()
                .id(id)
                .name(name)
                .description(description)
                .auctionIndex(auctionIndex)
                .auctionConsecutiveNumber(auctionConsecutiveNumber)
                .nettPrice(nettPrice)
                .vat(vat)
                .grossPrice(grossPrice)
                .ean(ean)
                .build();
    }
}