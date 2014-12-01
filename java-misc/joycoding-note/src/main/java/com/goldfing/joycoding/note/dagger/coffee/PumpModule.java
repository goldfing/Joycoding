package com.goldfing.joycoding.note.dagger.coffee;

import dagger.Module;
import dagger.Provides;

@Module (complete = false, library = true)
class PumpModule {
    @Provides
    Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
