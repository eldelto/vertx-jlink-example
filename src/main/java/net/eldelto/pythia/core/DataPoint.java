package net.eldelto.pythia.core;

import java.time.LocalDateTime;

public record DataPoint(LocalDateTime time, double value) {
}
