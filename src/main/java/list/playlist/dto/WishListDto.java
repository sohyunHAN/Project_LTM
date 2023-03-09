package list.playlist.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishListDto {

	@NotNull
	private Long plId;
	
	
	
}
