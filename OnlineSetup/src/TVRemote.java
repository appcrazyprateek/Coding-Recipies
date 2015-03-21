

import java.util.ArrayList;
import java.util.List;

/** 
 * SkyCast TV remote Problem
 * @author PRATEEK
 */
public class TVRemote {

	private int BackChannel = 0;
	private List<Integer> channels;
	private int currentIndex = 0;
	private int clicks = 0;
	private int totalChannels;

	public TVRemote(int low, int high, int[] blocked, int[] view) {
		channels = new ArrayList<Integer>(high - low);

		for (int i = low; i <= high; i++)
			channels.add(i);

		for (Integer o : blocked)
			channels.remove(o);

		totalChannels = channels.size();
	}
	
	public int solve(int low, int high, int[] view) {

		for (int i = 0; i < view.length; i++) {
			int toBeViewedChannel = view[i];
			int toBeViewedIndex = getIndex(toBeViewedChannel);

			int diff = getDiff(currentIndex, toBeViewedIndex);
			int absDiff = Math.abs(diff);

			int numDigits = String.valueOf(toBeViewedChannel).length();

			if (diff == 0) // same channel
				continue;

			else if (BackChannel == toBeViewedIndex) // when back is to be
														// pressed
				backPressed(toBeViewedIndex);

			else if (absDiff > numDigits) // when number of digits are less than
											// displacement
				goToChannel(toBeViewedChannel, toBeViewedIndex, numDigits);

			else // when displacement is less than number of digits
			{
				for (int j = 0; j < absDiff; j++) {
					if (diff < 0)
						downPressed();
					else
						upPressed();
				}
			}
		}
		return clicks;
	}

	/**
	 * Get the displacement between start Index to End Index in an Array
	 */
	private int getDiff(int start, int end) {
		int diff1 = Math.abs(end - start);
		int diff2 = Math.abs(totalChannels - diff1);
		
		if(start < end)
			return diff1 < diff2 ? diff1 : -diff2;
		else
			return diff1 < diff2 ? -diff1 : diff2;
	}

	/**
	 * @param channel
	 *            : given the channel
	 * @return : returns the index of the channel
	 */
	private int getIndex(int channel) {
		for (int index = 0; index < totalChannels; index++)
			if (channel == channels.get(index))
				return index;
		return 0;
	}

	private void goToChannel(int toBeViewedChannel, int toBeViewedIndex,
			int numDigits) {

		BackChannel = currentIndex;
		currentIndex = toBeViewedIndex;

		for (int j = 0; j < numDigits; j++)
			clicks++;
	}

	/**
	 * Up Button is pressed
	 */
	private void upPressed() {
		BackChannel = currentIndex;

		if (currentIndex == totalChannels - 1)
			currentIndex = 0;
		else
			currentIndex++;
		clicks++;
	}

	/**
	 * Down Button is Pressed
	 */
	private void downPressed() {
		BackChannel = currentIndex;

		if (currentIndex == 0)
			currentIndex = totalChannels - 1;
		else
			currentIndex--;
		clicks++;
	}

	/**
	 * Back BUtton is pressed
	 * @param toBeViewedIndex
	 */
	private void backPressed(int toBeViewedIndex) {
		BackChannel = currentIndex;
		currentIndex = toBeViewedIndex;
		clicks++;
	}
}
