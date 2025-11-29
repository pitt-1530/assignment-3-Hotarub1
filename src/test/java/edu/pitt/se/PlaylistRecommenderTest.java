package edu.pitt.se;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PlaylistRecommenderTest {

    @Test
    public void placeholder() {
        assertTrue(true);
    }

    @Test
    public void classifyEnergyTests() {
        List<Integer> bpmsHigh = List.of(150, 145, 160); 
        String result = PlaylistRecommender.classifyEnergy(bpmsHigh);
        assertEquals("HIGH", result);

        List<Integer> bpmsMid = List.of(100, 120, 160); 
        result = PlaylistRecommender.classifyEnergy(bpmsMid);
        assertEquals("MEDIUM", result);

        List<Integer> bpmsLow = List.of(50, 40, 120); 
        result = PlaylistRecommender.classifyEnergy(bpmsLow);
        assertEquals("LOW", result);

        assertThrows(IllegalArgumentException.class, () -> {
            PlaylistRecommender.classifyEnergy(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            PlaylistRecommender.classifyEnergy(List.of());
        });
    }

    @Test
    public void isValidTrackTitleTests() {
        String testTitle = "This is valid";
        boolean result = PlaylistRecommender.isValidTrackTitle(testTitle);
        assertTrue(result);

        testTitle = "This is n0t valid";
        result = PlaylistRecommender.isValidTrackTitle(testTitle);
        assertFalse(result);

        testTitle = "This is not valid because it is too long that is not good";
        result = PlaylistRecommender.isValidTrackTitle(testTitle);
        assertFalse(result);

        testTitle = "";
        result = PlaylistRecommender.isValidTrackTitle(testTitle);
        assertFalse(result);

        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
    }

    @Test
    public void normalizeVolumeTests() {
        int testVolume = 100;
        int result = PlaylistRecommender.normalizeVolume(testVolume);
        assertEquals(100, result);

        testVolume = 50;
        result = PlaylistRecommender.normalizeVolume(testVolume);
        assertEquals(50, result);

        testVolume = 0;
        result = PlaylistRecommender.normalizeVolume(testVolume);
        assertEquals(0, result);

        testVolume = 150;
        result = PlaylistRecommender.normalizeVolume(testVolume);
        assertEquals(100, result);

        testVolume = -50;
        result = PlaylistRecommender.normalizeVolume(testVolume);
        assertEquals(0, result);
    }
}
