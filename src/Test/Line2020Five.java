package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Line2020Five {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cards = {10, 13, 10, 1, 2, 3, 4, 5, 6, 2};
        bw.write(solution(cards) + "");
        bw.flush();
        bw.close();
    }

    static int startIndex = 0;

    // 딜러가 가지고 있는 카드
    static int[] dealer = new int[11];
    // 딜러 카드 총합 (1 제외)
    static int dealerSum = 0;

    // 플레이어 카드 총합 (1제외)
    static int playerSum = 0;
    // 플레이어 1 갯수
    static int playerOneCount = 0;

    // 카드 인덱스
    static int cardIndex = 0;

    static int answer = 0;
    public static int solution(int[] cards) {

        while(cardIndex < cards.length) {
            // 초기 설정 및 블랙잭 확인
            boolean first = first(cards);
            if(first) {
                startIndex = cardIndex;
                clearGame();
                // 카드 갯수가 부족
                if (cards.length - startIndex < 4) {
                    break;
                }
            }
            else {
                int player = playerSum;
                if(playerOneCount > 0) {
                    player += playerOneCount;
                }

                // 21보다 크면 짐
                if(player > 21) {
                    answer -= 2;
                    startIndex = cardIndex;
                    clearGame();
                    // 카드 갯수가 부족
                    if (cards.length - startIndex - 1 < 4) {
                        break;
                    }
                }
                // 21보다 작음 -> 딜러 카드에 따라 더 받을지 말지 결정
                else {
                    // 더이상 안 받음 -> 딜러가 17이상까지 카드를 계속 받음
                    if(dealer[4] > 0 || dealer[5] > 0 || dealer[6] > 0) {
                        int d = dealer(cards);
                        if(d > 21) {
                            answer += 2;
                        }
                        else if(d > player) {
                            answer -= 2;
                        }
                        else if(d < player) {
                            answer += 2;
                        }
                    }
                    // 플레이어가 합이 12가 될때까지
                    else if (dealer[2] > 0 || dealer[3] > 0) {
                        int p = play12(cards);
                        if(p > 21) {
                            answer -= 2;
                        }
                        int d = dealer(cards);
                        if(d > 21) {
                            answer += 2;
                        }
                        else if(d > player) {
                            answer -= 2;
                        }
                        else if(d < player) {
                            answer += 2;
                        }
                    }
                    // 플레이어가 합이 17이 될때 까지
                    else {
                        int p = play17(cards);
                        if(p > 21) {
                            answer -= 2;
                        }
                        int d = dealer(cards);
                        if(d > 21) {
                            answer += 2;
                        }
                        else if(d > player) {
                            answer -= 2;
                        }
                        else if(d < player) {
                            answer += 2;
                        }
                    }

                    startIndex = cardIndex;
                    clearGame();
                    // 카드 갯수가 부족
                    if (cards.length - startIndex - 1 < 4) {
                        break;
                    }
                }
            }
        }

        return answer;
    }

    // 딜러가 17이상까지 카드를 받음
    static int dealer(int[] cards) {
        while(true) {
            int d = dealerSum;
            for(int i = 0; i <= dealer[1]; i++) {
                if(d + i * 11 >= 17) {
                    return d + i * 11;
                }
            }

            int card = cards[cardIndex];
            dealer[card]++;
            if(card != 1) {
                dealerSum += card;
            }
        }
    }

    static int play12(int[] cards) {
        while(true) {
            int p = playerSum;
            for(int i = 0; i <= playerOneCount; i++) {
                if(p + i * 11 >= 12) {
                    return p + i * 11;
                }
            }

            int card = cards[cardIndex++];
            if(card != 1) {
                playerSum += card;
            }
            else {
                playerOneCount++;
            }
        }
    }

    static int play17(int[] cards) {
        while(true) {
            int p = playerSum;
            for(int i = 0; i <= playerOneCount; i++) {
                if(p + i * 11 >= 17) {
                    return p + i * 11;
                }
            }

            int card = cards[cardIndex++];
            if(card != 1) {
                playerSum += card;
            }
            else {
                playerOneCount++;
            }
        }
    }

    // 게임 초기 설정 및 블랙잭 확인
    static boolean first(int[] cards) {
        // 카드 나눠 갖음
        for(int i = 0; i < 4; i++) {
            int cardNum = cards[cardIndex];
            if(cardNum > 10) {
                cardNum = 10;
            }

            // 플레이어에게 카드 주기
            if(i % 2 == 0) {
                if(cardNum == 1) {
                    playerOneCount++;
                }
                else {
                    playerSum += cardNum;
                }
            }
            else {
                dealer[cardNum]++;
                if(cardNum != 1) {
                    dealerSum += cardNum;
                }
            }

            cardIndex++;
        }

        // 블랙잭
        if(playerSum == 10 && playerOneCount == 1) {
            // 딜러가 블랙잭 아니면
            if(!(dealerSum == 10 && dealer[1] == 1)) {
                answer += 3;
            }
            return true;
        }
        // 딜러가 블랙잭
        else if(dealerSum == 10 && dealer[1] == 1){
            if(!(playerSum == 10 && playerOneCount == 1)) {
                answer -= 2;
            }
            return true;
        }
        return false;
    }

    // 게임 판 초기화
    static void clearGame() {
        Arrays.fill(dealer, 0);
        dealerSum = 0;
        playerOneCount = 0;
        playerSum = 0;
    }
}
