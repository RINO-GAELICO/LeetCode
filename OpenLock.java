package leetCode;

public class OpenLock {

	public OpenLock() {
		// TODO Auto-generated constructor stub
	}

	public int openLock(String[] deadends, String target) {

		boolean deadEndFound = false, targetHit = false, characterHit = false;

		StringBuilder wheel = new StringBuilder("0000");
		StringBuilder targetSB = new StringBuilder(target);

		int j = 0, k = 0;
		int count = 0;
		String wheelString = wheel.toString();

		while (!wheelString.equals(target) || j < wheel.length()) {

			while (!characterHit) {

				if (wheel.charAt(j) != target.charAt(j)) {
					if (target.charAt(j) > 5) {
						wheel.setCharAt(j, (char) (wheel.charAt(j) - 1));
						for (int i = 0; i < deadends.length; i++) {
							while (!deadEndFound) {
								String wheelString = wheel.toString();
								if (wheelString.equals(deadends[i])) {
									if (!deadEndFound) {
										wheel.setCharAt(j, (char) (k + 1));
										deadEndFound = true;

									}
								}
							}

						}
						if (!deadEndFound) {
							characterHit = true;
							count++;
						}
						deadEndFound = false;
						k--;

					} else {
						wheel.setCharAt(j, (char) (wheel.charAt(j) + 1));

						for (int i = 0; i < deadends.length; i++) {
							wheelString = wheel.toString();

							if (wheelString.equals(deadends[i])) {
								if (!deadEndFound) {
									wheel.setCharAt(j, (char) (k - 1));
									deadEndFound = true;
								}

							}

						}
						if (!deadEndFound) {
							characterHit = true;
							count++;

						}
						deadEndFound = false;
						k++;

					}

				}else {
					characterHit = true;
				}

			}
			characterHit = false;
			j++;
			wheelString = wheel.toString();

		}
		if (wheel.equals(targetSB)) {
			return count;
		} else
			return -1;

	}

}
