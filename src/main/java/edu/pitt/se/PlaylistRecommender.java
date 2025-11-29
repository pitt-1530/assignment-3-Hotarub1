package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if(bpms == null)
            throw new IllegalArgumentException("bpms is null");
        if(bpms.isEmpty())
            throw new IllegalArgumentException("bpms is empty");

        int total = 0;
        for(int i = 0; i < bpms.size(); i++) {
            total += bpms.get(i);
        }

        int avg = total / bpms.size();
        if(avg >= 140) 
            return "HIGH";
        else if(avg >= 100 && avg <= 139)
            return "MEDIUM";
        else
            return "LOW";
    }

    public static boolean isValidTrackTitle(String title) { 
        if(title == null || title.length() < 1 || title.length() > 30) {
            return false;
        }

        for(char c : title.toCharArray()) {
            if(!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if(volumeDb > 100) 
            return 100;
        else if(volumeDb < 0)
            return 0;
        else
            return volumeDb;
    }
}
