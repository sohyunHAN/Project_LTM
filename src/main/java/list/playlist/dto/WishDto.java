package list.playlist.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishDto {

	@NotNull
	private Long playListId;
	
	
	
}
