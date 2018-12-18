package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import com.nhncorp.lucy.security.xss.XssSaxFilter;

public class LucyTest {

	@Test
	public void xssEscapeTest() {
		String dirty = "<script>alert('dirty');</script>";
		String clean = XssSaxFilter.getInstance().doFilter(dirty).replace("<!-- Not Allowed Tag Filtered -->", "");

		assertThat(clean).isNotEqualTo(dirty);
		assertThat(clean.contains("<")).isEqualTo(false);
		assertThat(clean.contains(">")).isEqualTo(false);
		assertThat(clean.contains("&lt;")).isEqualTo(true);
		assertThat(clean.contains("&gt;")).isEqualTo(true);
	}
}
