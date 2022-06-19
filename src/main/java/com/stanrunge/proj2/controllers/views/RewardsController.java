package com.stanrunge.proj2.controllers.views;

import com.stanrunge.proj2.JavaFXApplication;
import com.stanrunge.proj2.controllers.data.RewardController;
import com.stanrunge.proj2.controllers.data.UserController;
import com.stanrunge.proj2.data.Reward;
import com.stanrunge.proj2.data.User;
import com.stanrunge.proj2.repositories.RewardRepository;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.springframework.stereotype.Component;

@Component
public class RewardsController {

    UserController userController;
    User currentUser;

    RewardController rewardController;
    Iterable<Reward> rewards;

    @FXML
    TableView<Reward> rewardsTable;

    @FXML
    TableColumn<Reward, String> nameColumn;

    @FXML
    TableColumn<Reward, String> costColumn;

    @FXML
    TableColumn<Reward, Void> redeemButtonColumn;

    @FXML
    Label redeemedLabel;

    public RewardsController(RewardRepository rewardRepository) {
        JavaFXApplication.setRewardController(new RewardController(rewardRepository));
    }

    @FXML
    private void initialize() {
        userController = JavaFXApplication.getUserController();
        currentUser = JavaFXApplication.getLoggedInUser();

        rewardController = JavaFXApplication.getRewardController();
        rewards = rewardController.getRewards();
        for (Reward reward : rewards) {
            rewardsTable.getItems().add(reward);
        }

        fillTable();

        // Sort the table by cost
        rewardsTable.getSortOrder().add(costColumn);

        redeemedLabel.setText("");
    }

    private void fillTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        Callback<TableColumn<Reward, Void>, TableCell<Reward, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Reward, Void> call(final TableColumn<Reward, Void> param) {
                return new TableCell<>() {
                    private final Button button = new Button("Redeem");

                    {
                        button.setOnAction(event -> {
                            Reward reward = getTableView().getItems().get(getIndex());
                            if(currentUser.redeemReward(reward)) {
                                redeemedLabel.setText("You have redeemed " + reward.getName());
                            } else {
                                redeemedLabel.setText("You do not have enough points to redeem " + reward.getName());
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        };
        redeemButtonColumn.setCellFactory(cellFactory);

    }
}
