package state.room.state;

public interface RoomState {
	public void bookRoom();
	
	public void checkInRoom();
	
	public void unsubscribeRoom();
	
	public void checkOutRoom();
}
