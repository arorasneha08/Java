public class DesignATMmachine {
    class ATM {
        long arr[];
        int notes[] = { 20, 50, 100, 200, 500 };

        public ATM() {
            arr = new long[5];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++) {
                arr[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int used[] = new int[5];
            long newArr[] = arr.clone();

            for (int i = 4; i >= 0; i--) {
                int take = (int) Math.min(newArr[i], amount / notes[i]);
                used[i] = take;
                amount -= take * notes[i];
            }
            if (amount != 0) {
                return new int[] { -1 };
            }
            for (int i = 0; i < 5; i++) {
                arr[i] -= used[i];
            }
            return used;
        }
    }

}
