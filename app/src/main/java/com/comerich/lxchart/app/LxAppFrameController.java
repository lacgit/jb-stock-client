package com.comerich.lxchart.app;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.StatusBar;
import org.kordamp.desktoppanefx.scene.layout.DesktopPane;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@FxmlView("/com/comerich/lxchart/app/AppFrame.fxml")
@PropertySource("classpath:/com/comerich/lxchart/app/config.properties")
public class LxAppFrameController {
    @Value("${mHsif}")      private String mNameHsif;
    @Value("${mHhif}")      private String mNameHhif;
    @Value("${mHtif}")      private String mNameHtif;
	@Value("${mAm}")		private String mNameAm;
	@Value("${mExtAm}")		private String mNameExtAm;
	@Value("${mCt12}")		private String mNameCt12;
	@Value("${mDaily}")		private String mNameDaily;
	@Value("${mWeek}")		private String mNameWeek;
	@Value("${mMultiDay}")	private String mNameMultiDay;
	@Value("${mMonth}")		private String mNameMonth;
	@Value("${mUsMonth}")	private String mNameUsMonth;
	@Value("${mQuarter}")	private String mNameQuarter;
	@Value("${m2Year}")		private String mName2Year;
	@Value("${m5Year}")		private String mName5Year;

	@FXML
	BorderPane	bp_main;		//	top pane of application
	@FXML
	DesktopPane dp_mainFrame;	//	main application frame
	@FXML
	StatusBar	sb_frameStatus;	//	top frame status

	@FXML
	public  void    initialize() {
		dp_mainFrame.setTop(buildFrameMenuBar());
	}

	private	MenuBar	buildFrameMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu    mFile   = new Menu("File");
		Menu    mHsif   = new Menu(mNameHsif);
		Menu    mHhif   = new Menu(mNameHhif);
		Menu    mHtif   = new Menu(mNameHtif);
		Menu    mHelp   = new Menu("Help");
		mHsif.getItems().addAll(buildIndexMenuList("Alt"));
		mHhif.getItems().addAll(buildIndexMenuList("Alt+Shift"));
		mHtif.getItems().addAll(buildIndexMenuList(null));
		menuBar.getMenus().addAll(mFile, mHsif, mHhif, mHtif, mHelp);
		return	menuBar;
	}

	private List<MenuItem> buildIndexMenuList(String key) {
		MenuItem	mAm			=	new MenuItem(mNameAm);
		MenuItem	mExtAm		=	new MenuItem(mNameExtAm);
		MenuItem	mCt12		=	new MenuItem(mNameCt12);
		MenuItem	mDaily		=	new MenuItem(mNameDaily);
		MenuItem	mWeek		=	new MenuItem(mNameWeek);
		MenuItem	mMultiDay	=	new MenuItem(mNameMultiDay);
		MenuItem	mMonth		=	new MenuItem(mNameMonth);
		MenuItem	mUsMonth	=	new MenuItem(mNameUsMonth);
		MenuItem	mQuarter	=	new MenuItem(mNameQuarter);
		MenuItem	m2Year		=	new MenuItem(mName2Year);
		MenuItem	m5Year		=	new MenuItem(mName5Year);

		if (key!=null && !key.isEmpty()) {
			mAm.setAccelerator		(KeyCombination.keyCombination(key + "+A"));
			mExtAm.setAccelerator	(KeyCombination.keyCombination(key + "+B"));
			mCt12.setAccelerator	(KeyCombination.keyCombination(key + "+C"));
			mDaily.setAccelerator	(KeyCombination.keyCombination(key + "+D"));
			mWeek.setAccelerator	(KeyCombination.keyCombination(key + "+E"));
			mMultiDay.setAccelerator(KeyCombination.keyCombination(key + "+F"));
			mMonth.setAccelerator	(KeyCombination.keyCombination(key + "+G"));
			mUsMonth.setAccelerator	(KeyCombination.keyCombination(key + "+H"));
			mQuarter.setAccelerator	(KeyCombination.keyCombination(key + "+I"));
			m2Year.setAccelerator	(KeyCombination.keyCombination(key + "+J"));
			m5Year.setAccelerator	(KeyCombination.keyCombination(key + "+K"));
		}

		return Arrays.asList(mAm, mExtAm, mCt12, mDaily, mWeek, mMultiDay
				, mMonth, mUsMonth, mQuarter, m2Year, m5Year);
	}
}
