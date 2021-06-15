package net.eldelto.pythia.core;

import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface Exchange {
    Flux<String> getAssets();
    Flux<DataPoint> getPrice(String assetName, LocalDateTime startDate, LocalDateTime endDate);
    TradingFees getTradingFees();
}

