package me.geso.avans;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.geso.webscrew.Parameters;
import me.geso.webscrew.request.WebRequest;
import me.geso.webscrew.response.WebResponse;

public interface Controller extends AutoCloseable {

	void init(final HttpServletRequest request,
			final HttpServletResponse response,
			final Map<String, String> captured);

	public WebRequest getRequest();

	public Parameters getPathParameters();

	public WebResponse renderJSON(final Object obj);

	public void invoke(final Method method, final HttpServletRequest request,
			final HttpServletResponse response,
			final Map<String, String> captured);

	/**
	 * Stash space for the plugins. You can store the plugin specific data into
	 * here.
	 * 
	 * @return
	 */
	public Map<String, Object> getPluginStash();

	public Path getBaseDirectory();
}
