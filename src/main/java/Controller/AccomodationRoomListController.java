package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.AccomodationSerachCommand;
import Model.AccomodationRegisterDTO;
import Service.AccomodationRoomListService;


@Controller
public class AccomodationRoomListController {

	
	@Autowired
	AccomodationRoomListService accomodationRoomListService;
	
	@RequestMapping("/roomlist")
	public String form(Model model) {
		List<AccomodationRegisterDTO> list = new ArrayList<AccomodationRegisterDTO>();


		list=accomodationRoomListService.accomodationRoomList();
		model.addAttribute("list", list);

		return "AccomodationRoomList/AccomodationRoomList";
	}
	
	@RequestMapping("/roomlistsearch")
	public String form1(Model model,AccomodationSerachCommand accomodationSerachCommand) {
		List<AccomodationRegisterDTO> list = new ArrayList<AccomodationRegisterDTO>();

      System.out.println("첫번째"+accomodationSerachCommand.getaProMeal());
		list=accomodationRoomListService.accomodationRoomListSerach(accomodationSerachCommand);
		model.addAttribute("list", list);

		return "AccomodationRoomList/AccomodationRoomList";
	}

}


