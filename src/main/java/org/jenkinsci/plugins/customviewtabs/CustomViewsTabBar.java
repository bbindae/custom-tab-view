package org.jenkinsci.plugins.customviewtabs;

import hudson.Extension;
import hudson.views.ViewsTabBar;
import hudson.views.ViewsTabBarDescriptor;
import hudson.util.ListBoxModel;
import hudson.util.ListBoxModel.Option;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;


public class CustomViewsTabBar extends ViewsTabBar {
   
    @DataBoundConstructor
    public CustomViewsTabBar() {
        super();
    }
    
    @Extension
    public static final class CustomViewsTabBarDescriptor extends ViewsTabBarDescriptor {
    	
    	private String labelText = "initial";
    	private String tabColour = "00ff00";
    	
        public CustomViewsTabBarDescriptor() {
            load();
        }

        @Override
        public String getDisplayName() {
            return "Custom Views TabBar";
        }
    	
        public String getLabelText(){
        	return labelText;
        }
        
        @Override
        public boolean configure(StaplerRequest req, JSONObject formData) throws FormException {
            labelText = formData.getString("labelText");
            tabColour = formData.getString("tabColour");      
            
            save();
            return false;
        }
        
        public ListBoxModel doFillTabColourItems(){
        	return new ListBoxModel(
        			new Option("Green","00ff00", tabColour.equals("00ff00")),
        			new Option("Yello","ffff00", tabColour.equals("ffff00")),
        			new Option("Red","ff0000",tabColour.equals("ff0000")));
        }
    }
}
