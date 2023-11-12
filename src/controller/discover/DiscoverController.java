/*-----------------------------------------------------------------------------------------
 * NAME : DiscoverController.java
 * VER  : v0.1
 * PROJ : Akara
 * CODE CLEAN? : Yes
 *-----------------------------------------------------------------------------------------
 *                      H      I      S      T      O      R      Y
 *-----------------------------------------------------------------------------------------
 *   DATE        AUTHOR         DESCRIPTION
 * ----------  --------------  ------------------------------------------------------------
 * 2022-06-24   Nuth Vireak     creation
 * ----------  --------------  ------------------------------------------------------------
 * 2022-08-03   Nuth Vireak     Modification
 *---------------------------------------------------------------------------------------*/

package controller.discover;

import com.github.javafaker.Faker;
import controller.main.MainFormController;
import controller.main.PodcastHboxController;
import controller.main.PodcastVboxController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Podcast;
import model.RecentlyPlayed;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class DiscoverController implements Initializable {

    //------------------------------------------------------------------------------------
    // fields declaration                                                               |
    //------------------------------------------------------------------------------------

    public static List<RecentlyPlayed> recentlyPlayed;
    public static List<Podcast> popularPodcast;
    public static List<Podcast> topPodcastInGaming;
    public static List<Podcast> topPodcastInTechnology;
    public static List<Podcast> topPodcastInHistory;
    public static List<Podcast> topPodcastInComedy;
    public static List<Podcast> topPodcastInProgrammingLanguage;
    @FXML
    private BorderPane borderPane;
    @FXML
    private HBox recentlyPlayedContainer;
    @FXML
    private HBox popularPodcastContainer;
    @FXML
    private HBox topPodcastInGamingContainer;
    @FXML
    private HBox topPodcastInTechnologyContainer;
    @FXML
    private HBox topPodcastInHistoryContainer;
    @FXML
    private HBox topPodcastInComedyContainer;
    @FXML
    private HBox topPodcastInProgrammingLanguageContainer;
    @FXML
    private Label seeAllPopularPodcast;
    @FXML
    private Label seeAllTopPodcastInGaming;
    @FXML
    private Label seeAllTopPodcastInTechnology;
    @FXML
    private Label seeAllTopPodcastInHistory;
    @FXML
    private Label seeAllTopPodcastInComedy;
    @FXML
    private Label seeAllTopPodcastInProgrammingLanguage;
    // anchor pane
    private AnchorPane popularPane;
    private AnchorPane topGamingPane;
    private AnchorPane topTechPane;
    private AnchorPane topHistoryPane;
    private AnchorPane topComedyPane;
    private AnchorPane topProgrammingPane;

    //------------------------------------------------------------------------------------
    //  Methods declaration                                                              |
    //------------------------------------------------------------------------------------

    private static List<Podcast> getPopularPodcast() {

        List<Podcast> popularPodcast = new ArrayList<>();

        for (Podcast podcast : MainFormController.podcastList) {
            if (podcast.getViewCount() > 5000) {
                if (popularPodcast.size() < 10) {
                    popularPodcast.add(podcast);
                }
            }
        }
        return popularPodcast;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // always update recentlyPlayed panel
        try {
            recentlyPlayed = new ArrayList<>(getRecentlyPlayed());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        recentlyPlayedContainer.getChildren().clear();
        try {
            for (RecentlyPlayed podcast : recentlyPlayed) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/view/main/podcastHbox.fxml"));

                HBox hBox = fxmlLoader.load();

                PodcastHboxController podcastHboxController = fxmlLoader.getController();
                podcastHboxController.setData(podcast);

                recentlyPlayedContainer.getChildren().add(hBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // one init is enough
        if (!MainFormController.init) {
            System.out.println("Do it!");
            // Initialize the lists of podcasts to be displayed in the Discover page

            popularPodcast = new ArrayList<>(getPopularPodcast());
            topPodcastInGaming = new ArrayList<>(getTopPodcastInGaming());
            topPodcastInTechnology = new ArrayList<>(getTopPodcastInTechnology());
            topPodcastInHistory = new ArrayList<>(getTopPodcastInHistory());
            topPodcastInComedy = new ArrayList<>(getTopPodcastInComedy());
            topPodcastInProgrammingLanguage = new ArrayList<>(getTopPodcastInProgrammingLanguage());

            try {

                for (Podcast podcast : popularPodcast) {
                    popularPane = getAnchorPane(podcast);
                    popularPodcastContainer.getChildren().add(popularPane);
                }

                for (Podcast podcast : topPodcastInGaming) {
                    topGamingPane = getAnchorPane(podcast);
                    topPodcastInGamingContainer.getChildren().add(topGamingPane);
                }

                for (Podcast podcast : topPodcastInTechnology) {
                    topTechPane = getAnchorPane(podcast);
                    topPodcastInTechnologyContainer.getChildren().add(topTechPane);
                }

                for (Podcast podcast : topPodcastInHistory) {
                    topHistoryPane = getAnchorPane(podcast);
                    topPodcastInHistoryContainer.getChildren().add(topHistoryPane);
                }

                for (Podcast podcast : topPodcastInComedy) {
                    topComedyPane = getAnchorPane(podcast);
                    topPodcastInComedyContainer.getChildren().add(topComedyPane);
                }

                for (Podcast podcast : topPodcastInProgrammingLanguage) {
                    topProgrammingPane = getAnchorPane(podcast);
                    topPodcastInProgrammingLanguageContainer.getChildren().add(topProgrammingPane);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            MainFormController.init = true;
        }


    }

    private List<RecentlyPlayed> getRecentlyPlayed() throws IOException, ClassNotFoundException {

        URL recentFile = new URL("https://cdn.discordapp.com/attachments/1031830312788951100/1173158409344909352/recentPlayed.txt");

        List<RecentlyPlayed> recentlyPlayedList = new ArrayList<>();


        System.out.println("Found!");
        // check to make sure it's not duplicate
        ObjectInputStream oi = new ObjectInputStream(recentFile.openStream());

        List<RecentlyPlayed> recentlyPlayed = (List<RecentlyPlayed>) oi.readObject();
        recentlyPlayedList.addAll(recentlyPlayed);

        for (RecentlyPlayed recentlyPlayed1 : recentlyPlayedList) {
            System.out.println(recentlyPlayed1.toString());
        }
        oi.close();

        return recentlyPlayedList;
    }

    private List<Podcast> getTopPodcastInGaming() {

        List<Podcast> topPodcastInGaming = new ArrayList<>();

        for (Podcast podcast : MainFormController.podcastList) {
            if (podcast.getGenre().equals("Gaming")) {
                if (topPodcastInGaming.size() < 10) {
                    topPodcastInGaming.add(podcast);
                }
            }
        }
        return topPodcastInGaming;
    }

    private List<Podcast> getTopPodcastInTechnology() {

        List<Podcast> topPodcastInTechnology = new ArrayList<>();

        for (Podcast podcast : MainFormController.podcastList) {
            if (podcast.getGenre().equals("Technology")) {
                if (topPodcastInTechnology.size() < 10) {
                    topPodcastInTechnology.add(podcast);
                }
            }
        }
        return topPodcastInTechnology;
    }

    private List<Podcast> getTopPodcastInHistory() {

        List<Podcast> topPodcastInHistory = new ArrayList<>();

        for (Podcast podcast : MainFormController.podcastList) {
            if (podcast.getGenre().equals("History")) {
                if (topPodcastInHistory.size() < 10) {
                    topPodcastInHistory.add(podcast);
                }
            }
        }
        return topPodcastInHistory;
    }

    private List<Podcast> getTopPodcastInComedy() {

        List<Podcast> topPodcastInComedy = new ArrayList<>();

        for (Podcast podcast : MainFormController.podcastList) {
            if (podcast.getGenre().equals("Comedy")) {
                if (topPodcastInComedy.size() < 10) {
                    topPodcastInComedy.add(podcast);
                }
            }
        }
        return topPodcastInComedy;
    }

    private List<Podcast> getTopPodcastInProgrammingLanguage() {

        List<Podcast> topPodcastInProgrammingLanguage = new ArrayList<>();

        for (Podcast podcast : MainFormController.podcastList) {
            if (podcast.getGenre().equals("Programming")) {
                if (topPodcastInProgrammingLanguage.size() < 10) {
                    topPodcastInProgrammingLanguage.add(podcast);
                }
            }
        }
        return topPodcastInProgrammingLanguage;
    }

    @FXML
    void seeAllClick(MouseEvent event) throws Exception {

        Faker faker = new Faker();

        BorderPane discoverSeeAll = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/discover/DiscoverSeeAll.fxml")));
        MainFormController.staticBorderpane.setCenter(discoverSeeAll);

        if (event.getSource() == seeAllPopularPodcast) {

            System.out.println("See all popular podcasts");
            String title = "Popular Podcasts";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setPopularPodcastToView();

        } else if (event.getSource() == seeAllTopPodcastInGaming) {

            System.out.println("See all Top podcast in gaming");
            String title = "Top Podcast in Gaming";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInGamingToView();
        } else if (event.getSource() == seeAllTopPodcastInTechnology) {

            System.out.println("See all Top podcast in Technology");
            String title = "Top Podcast in Technology";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInTechnologyToView();
        } else if (event.getSource() == seeAllTopPodcastInHistory) {

            System.out.println("See all Top podcast in History");
            String title = "Top Podcast in History";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInHistoryToView();
        } else if (event.getSource() == seeAllTopPodcastInComedy) {

            System.out.println("See all Top podcast in Comedy");
            String title = "Top Podcast in Comedy";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInComedyToView();
        } else if (event.getSource() == seeAllTopPodcastInProgrammingLanguage) {

            System.out.println("See all Top podcast in Programming Language");
            String title = "Top Podcast in Programming Language";
            String description = faker.lorem().paragraph(10);

            System.out.println("Title: " + title);

            setTitleAndDescriptionToDiscoverSeeAllStaticView(title, description);

            DiscoverSeeAllController.setTopPodcastInProgrammingLanguageToView();
        }
    }

    private void setTitleAndDescriptionToDiscoverSeeAllStaticView(String title, String description) {

        DiscoverSeeAllController.setTitleDiscoverSeeAllStatic(title);
        DiscoverSeeAllController.setDescriptionSeeAllStatic(description);
    }

    private AnchorPane getAnchorPane(Podcast podcast) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/view/main/podcastVbox.fxml"));

        AnchorPane anchorPane = fxmlLoader.load();
        PodcastVboxController podcastVboxController = fxmlLoader.getController();
        podcastVboxController.setData(podcast);
        return anchorPane;
    }

} // end of class DiscoverController
