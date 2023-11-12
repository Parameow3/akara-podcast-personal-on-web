/*-----------------------------------------------------------------------------------------
 * NAME : RandomSoundPodcast.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package model;

import java.util.ArrayList;
import java.util.List;

public enum RandomSoundPodcast {
        // for local
//    SOUND_PODCAST_1(1, "src/podcastSound/After_Midnight_-_Paxton_Pennington.mp3"),
//    SOUND_PODCAST_2(2, "src/podcastSound/Bright_Red_and_March_Away_-_Ping_Pong_Club.mp3"),
//    SOUND_PODCAST_3(3, "src/podcastSound/Done_With_You_-_SadMe.mp3"),
//    SOUND_PODCAST_4(4, "src/podcastSound/Hourglass_-_Glass_Violet.mp3"),
//    SOUND_PODCAST_5(5, "src/podcastSound/I_K_W_Y_B_-_Forget_the_Whale_(2).mp3"),
//    SOUND_PODCAST_6(6, "src/podcastSound/ilyab_-_Flame_Up_-_ilyab.mp3"),
//    SOUND_PODCAST_7(7, "src/podcastSound/Infinite_Blanket_-_Kara_Square_and_Piero_Peluche.mp3"),
//    SOUND_PODCAST_8(8, "src/podcastSound/KAI-Mascara.mp3"),
//    SOUND_PODCAST_9(9, "src/podcastSound/Less_Affected_-_equals.conquest.mp3"),
//    SOUND_PODCAST_10(10, "src/podcastSound/Misery_Business_-_Plants.mp3"),
//    SOUND_PODCAST_11(11, "src/podcastSound/Oh_So_Insecure_-_Jon_Worthy.mp3"),
//    SOUND_PODCAST_12(12, "src/podcastSound/Set_The_Goals_-_Mouse_In_Da_Chaos_(3).mp3"),
//    SOUND_PODCAST_13(13, "src/podcastSound/Talking_Cure_-_Of_Beauty_and_Love.mp3"),
//    SOUND_PODCAST_14(14, "src/podcastSound/VANNDA-C.O.D.A.mp3"),
//    SOUND_PODCAST_15(15, "src/podcastSound/VANNDA-DADDY-DA.mp3");

    SOUND_PODCAST_1(1, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149001063878666/After_Midnight_-_Paxton_Pennington.mp3"),
    SOUND_PODCAST_2(2, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149001365860382/Bright_Red_and_March_Away_-_Ping_Pong_Club.mp3"),
    SOUND_PODCAST_3(3, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149001802072114/Done_With_You_-_SadMe.mp3"),
    SOUND_PODCAST_4(4, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149002125037628/Hourglass_-_Glass_Violet.mp3"),
    SOUND_PODCAST_5(5, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149002464768101/I_K_W_Y_B_-_Forget_the_Whale_2.mp3"),
    SOUND_PODCAST_6(6, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149008840097812/Oh_So_Insecure_-_Jon_Worthy.mp3"),
    SOUND_PODCAST_7(7, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149009158869022/Set_The_Goals_-_Mouse_In_Da_Chaos_3.mp3"),
    SOUND_PODCAST_8(8, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149009968373841/Talking_Cure_-_Of_Beauty_and_Love.mp3"),
    SOUND_PODCAST_9(9, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149010287132683/VANNDA-C.O.D.A.mp3"),
    SOUND_PODCAST_10(10, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149010576543775/VANNDA-DADDY-DA.mp3"),
    SOUND_PODCAST_11(11, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149020043104296/ilyab_-_Flame_Up_-_ilyab.mp3"),
    SOUND_PODCAST_12(12, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149020349280336/Infinite_Blanket_-_Kara_Square_and_Piero_Peluche.mp3"),
    SOUND_PODCAST_13(13, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149020651262052/KAI-Mascara.mp3"),
    SOUND_PODCAST_14(14, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149021146206318/Less_Affected_-_equals.conquest.mp3"),
    SOUND_PODCAST_15(15, "https://cdn.discordapp.com/attachments/1031830312788951100/1173149021456576523/Misery_Business_-_Plants.mp3");
    private final int soundPodcastID;
    private final String soundPodcastUrl;

    RandomSoundPodcast(int soundPodcastID, String soundPodcastUrl) {
        this.soundPodcastID = soundPodcastID;
        this.soundPodcastUrl = soundPodcastUrl;
    }

    public static List<String> getAllURL(){
        List<String> allURL = new ArrayList<>();
        for (RandomSoundPodcast soundPodcast: RandomSoundPodcast.values()){
            allURL.add(soundPodcast.getSoundPodcastUrl());
        }
        return allURL;
    }

    public int getSoundPodcastID() {
        return soundPodcastID;
    }

    public String getSoundPodcastUrl() {
        return soundPodcastUrl;
    }
}
