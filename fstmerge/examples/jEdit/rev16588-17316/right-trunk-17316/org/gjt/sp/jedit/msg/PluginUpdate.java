

package org.gjt.sp.jedit.msg;

import org.gjt.sp.jedit.*;


public class PluginUpdate extends EBMessage
{
	
	
	public static final Object LOADED = "LOADED";

	
	public static final Object ACTIVATED = "ACTIVATED";

	
	public static final Object DEACTIVATED = "DEACTIVATED";

	
	public static final Object UNLOADED = "UNLOADED";
	

	
	
	public PluginUpdate(PluginJAR jar, Object what, boolean exit)
	{
		super(jar);

		if(what == null)
			throw new NullPointerException("What must be non-null");

		EditPlugin plugin = jar.getPlugin();
		if (plugin != null)
		{
			String clazz = plugin.getClassName();
			version = jEdit.getProperty("plugin."+clazz+".version");
		}
		this.what = what;
		this.exit = exit;
	} 

	
	
	public Object getWhat()
	{
		return what;
	} 

	
	
	public boolean isExiting()
	{
		return exit;
	} 

	
	
	public PluginJAR getPluginJAR()
	{
		return (PluginJAR)getSource();
	} 

	
	
	public String getPluginVersion()
	{
		return version;
	} 

	
	public String paramString()
	{
		return "what=" + what + ",exit=" + exit + ",version=" + version + ","
			+ super.paramString();
	} 

	
	private Object what;
	private boolean exit;
	private String version;
	
}