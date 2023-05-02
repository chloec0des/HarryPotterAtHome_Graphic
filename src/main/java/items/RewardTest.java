package items;

public class RewardTest {
        public static void main(String[] args) {
            testRewardConstructor();
            testGetReward();
            testSetReward();
            testGetName();
        }

        public static void testRewardConstructor() {
            Reward reward = new Reward("Gold Coin");
            if (!reward.getReward().equals("Gold Coin")) {
                System.err.println("testRewardConstructor failed: Expected 'Gold Coin', but got '" + reward.getReward() + "'");
            } else {
                System.out.println("testRewardConstructor passed.");
            }
        }

        public static void testGetReward() {
            Reward reward = new Reward("Silver Coin");
            if (!reward.getReward().equals("Silver Coin")) {
                System.err.println("testGetReward failed: Expected 'Silver Coin', but got '" + reward.getReward() + "'");
            } else {
                System.out.println("testGetReward passed.");
            }
        }

        public static void testSetReward() {
            Reward reward = new Reward("Bronze Coin");
            reward.setReward("Diamond");
            if (!reward.getReward().equals("Diamond")) {
                System.err.println("testSetReward failed: Expected 'Diamond', but got '" + reward.getReward() + "'");
            } else {
                System.out.println("testSetReward passed.");
            }
        }

        public static void testGetName() {
            Reward reward = new Reward("Emerald");
            if (!reward.getName().equals("Emerald")) {
                System.err.println("testGetName failed: Expected 'Emerald', but got '" + reward.getName() + "'");
            } else {
                System.out.println("testGetName passed.");
            }
        }
}
