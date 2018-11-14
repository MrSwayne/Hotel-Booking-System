package hbs.factory;

import hbs.factory.SingleRoom;
import hbs.interfaces.IRoom;
import hbs.factory.DoubleRoom;

public class RoomFactory extends AbstractFactory {

	@Override
	public IRoom getRoom(String roomType) {
		if(roomType == null)
			return null;

		if(roomType.equalsIgnoreCase("SINGLE"))
			return new SingleRoom();
		else if(roomType.equalsIgnoreCase("DOUBLE"))
			return new DoubleRoom();

		return null;
	}
}