package hbs.factory;

import hbs.interfaces.IRoom;

public abstract class AbstractFactory {

	abstract IRoom getRoom(String room);
}