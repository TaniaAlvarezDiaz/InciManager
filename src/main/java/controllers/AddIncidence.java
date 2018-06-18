package controllers;

import org.springframework.ui.Model;

public interface AddIncidence {

	String addIncidence(Model model);

	String addIncidence(String name, String description, String tags, String properties);
}
