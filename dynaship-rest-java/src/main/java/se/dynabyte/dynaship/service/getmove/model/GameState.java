package se.dynabyte.dynaship.service.getmove.model;

import java.util.Collection;

import javax.validation.constraints.Min;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import se.dynabyte.dynaship.service.getmove.validation.ValidCollection;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameState {
	
	@Min(1)
	private final int boardSize;
	
	@ValidCollection(elementType = Shot.class) 
	private final Collection<Shot> shots;
	
	@ValidCollection(elementType = Ship.class) 
	private final Collection<Ship> ships;

	@JsonCreator
	public GameState(
			@JsonProperty("size") int boardSize,
			@JsonProperty("shots") Collection<Shot> shots,
			@JsonProperty("boats") Collection<Ship> ships) {
		
		this.boardSize = boardSize;
		this.shots = shots;
		this.ships = ships;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public Collection<Shot> getShots() {
		return shots;
	}

	public Collection<Ship> getShips() {
		return ships;
	}
	
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).build();
	}
}
