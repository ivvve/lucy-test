package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import com.nhncorp.lucy.security.xss.XssSaxFilter;

public class LucyTest {

	@Test
	public void xssEscapeTest() {
		// given
		String dirty = "<script>alert('dirty');</script>";

		// when
		String clean = XssSaxFilter.getInstance().doFilter(dirty);
		System.out.println(clean);
		clean = clean.replace("<!-- Not Allowed Tag Filtered -->", "");
		System.out.println(clean);

		// then
		assertThat(clean).isNotEqualTo(dirty);
		assertThat(clean.contains("<")).isEqualTo(false);
		assertThat(clean.contains(">")).isEqualTo(false);
		assertThat(clean.contains("&lt;")).isEqualTo(true);
		assertThat(clean.contains("&gt;")).isEqualTo(true);
	}
}
