package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    public static void printPlayerHandCardList(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.printf("玩家 [%s] 的手牌是: %s%n", player.name, player.cardList);
        }
    }

    public static void main(String[] args) {
        // 5 名玩家，使用 List
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("周润发"));
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("高博"));
        playerList.add(new Player("陈沛鑫"));
        playerList.add(new Player("许之琛"));

        // List 作为线性表，表现生活中很多有前后关系的物品都可以
        // 例如这里的牌组/衣柜/鞋柜 ...
        List<Card> cardList = new ArrayList<>();

        // 初始化扑克牌
        initializeCards(cardList);

        // 调用 Collections(jdk 提供的类）下的 shuffle（洗牌） 方法
        // 进行洗牌
        Collections.shuffle(cardList);
        System.out.println("抽牌前，牌组中的牌：");
        System.out.println(cardList);

        // 发牌
        int n = 4;  // 每名玩家发几张牌
        for (int i = 0; i < n; i++) {   // 一共发 n 轮牌
            for (Player player : playerList) {  // 每名玩家依次抽牌
                // 从牌组中，抽一张牌出来
                Card card = cardList.remove(0);

                // 把这张牌放到当前玩家的手中
                player.cardList.add(card);
            }
        }

        System.out.println("现在牌组中剩余的牌：");
        System.out.println(cardList);

        System.out.println("交换牌之前：");
        printPlayerHandCardList(playerList);

        // 要找的牌
        Card toFoundCard = new Card("♠", 1);

        // 我已知发哥的下标是 0
        Player 周润发 = playerList.get(0);

        发哥发功(周润发, toFoundCard, playerList);
        System.out.println("发哥第一次发功之后：");
        printPlayerHandCardList(playerList);

        /*
        for (Player player : playerList) {
            System.out.printf("玩家 [%s] 的手牌是: %s%n", player.name, player.cardList);
        }
        */

        Random random = new Random();
        // 交换牌
        // 每名玩家抽取其下家一张随机的手牌
        for (int i = 0; i < playerList.size(); i++) {
            Player currentPlayer = playerList.get(i);
            // 下家就是按照前后关系的下一个，最后一名玩家抽取第 0 个
            Player nextPlayer = playerList.get(i != playerList.size() - 1 ? i + 1 : 0);

            // 要取的牌的下标
            int toDrawIndex = random.nextInt(nextPlayer.cardList.size());
            // 取牌
            Card drawCard = nextPlayer.cardList.remove(toDrawIndex);
            // 放入当前玩家手中
            currentPlayer.cardList.add(drawCard);
        }

        System.out.println("交换牌之后：");
        printPlayerHandCardList(playerList);



        发哥发功(周润发, toFoundCard, playerList);
        System.out.println("发哥第二次发功之后：");
        printPlayerHandCardList(playerList);

        for (Player player : playerList) {
            if (player.cardList.indexOf(toFoundCard) != -1) {
            //if (player.cardList.contains(toFoundCard)) {
                System.out.println(player.name + " 获胜");
                return;
            }

            /*
            for (Card card : player.cardList) {
                // 比较每张牌和要找的那张牌是否是同一张牌
                // card 和 toFoundCard
                // if (toFoundCard.equals(card)) 也可以
                if (card.equals(toFoundCard)) {
                    System.out.println(player.name + " 获胜");
                    return;
                }
            }
            */
        }

        System.out.println("无人获胜");
    }

    public static void 发哥发功(Player 周润发, Card toFoundCard, List<Player> playerList) {
        if (!周润发.cardList.contains(toFoundCard)) {
            Card card = 周润发.cardList.get(0);
            周润发.cardList.set(0, toFoundCard);

            // 跳过 0 号下标
            for (int i = 1; i < playerList.size(); i++) {
                if (playerList.get(i).cardList.contains(toFoundCard)) {
                    // 下标为 i 的玩家持有黑桃 A
                    /*
                    playerList.get(i).cardList.remove(toFoundCard);
                    playerList.get(i).cardList.add(card);
                    */
                    int j = playerList.get(i).cardList.indexOf(toFoundCard);
                    playerList.get(i).cardList.set(j, card);
                }
            }
        }
        /*
        if (!周润发.cardList.contains(toFoundCard)) {
            周润发.cardList.set(0, toFoundCard);
            //周润发.cardList.set(0, new Card("♠", 1));
        }
        */
    }

    private static void initializeCards(List<Card> cardList) {
        String[] suits = new String[4];
        suits[0] = "♠";
        suits[1] = "♥";
        suits[2] = "♦";
        suits[3] = "♣";
        for (String suit : suits) {
            for (int rank = 1; rank <= 5; rank++) {
                Card card = new Card(suit, rank);

                // 把扑克牌放入牌组中
                cardList.add(card);
            }
        }
    }
}
