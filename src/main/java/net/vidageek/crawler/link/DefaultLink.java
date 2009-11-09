package net.vidageek.crawler.link;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.vidageek.crawler.LinksCrawler;

public class DefaultLink implements LinksCrawler {

	private final String content;

	public DefaultLink(final String content) {
		if (content == null || "".equals(content.trim())) {
			throw new IllegalArgumentException("content cannot be null");
		}
		this.content = content;
	}

	public List<String> getLinks() {
		Pattern pattern = Pattern.compile("(?i)(?s)<\\s*?a.*?href=\"(.*?)\".*?>");
		Matcher matcher = pattern.matcher(content);

		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			list.add(matcher.group(1));
		}

		return list;
	}

}
