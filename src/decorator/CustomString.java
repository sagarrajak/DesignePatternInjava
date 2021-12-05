package decorator;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles.Lookup;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CustomString {
	private String customString;
	
	public double countVowel() {
		return customString.chars()
			.mapToObj(c -> (char)c)
			.filter(c -> "aeiou".contains(c.toString()))
			.count();
	}
		
	public CustomString(String customString) {
		super();
		this.customString = customString;
	}

	///////////////////////
	public int length() {
		return customString.length();
	}

	public boolean isEmpty() {
		return customString.isEmpty();
	}

	public char charAt(int index) {
		return customString.charAt(index);
	}

	public int codePointAt(int index) {
		return customString.codePointAt(index);
	}

	public int codePointBefore(int index) {
		return customString.codePointBefore(index);
	}

	public int codePointCount(int beginIndex, int endIndex) {
		return customString.codePointCount(beginIndex, endIndex);
	}

	public int offsetByCodePoints(int index, int codePointOffset) {
		return customString.offsetByCodePoints(index, codePointOffset);
	}

	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		customString.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
		customString.getBytes(srcBegin, srcEnd, dst, dstBegin);
	}

	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		return customString.getBytes(charsetName);
	}

	public byte[] getBytes(Charset charset) {
		return customString.getBytes(charset);
	}

	public byte[] getBytes() {
		return customString.getBytes();
	}

	public boolean equals(Object anObject) {
		return customString.equals(anObject);
	}

	public boolean contentEquals(StringBuffer sb) {
		return customString.contentEquals(sb);
	}

	public boolean contentEquals(CharSequence cs) {
		return customString.contentEquals(cs);
	}

	public boolean equalsIgnoreCase(String anotherString) {
		return customString.equalsIgnoreCase(anotherString);
	}

	public int compareTo(String anotherString) {
		return customString.compareTo(anotherString);
	}

	public int compareToIgnoreCase(String str) {
		return customString.compareToIgnoreCase(str);
	}

	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return customString.regionMatches(toffset, other, ooffset, len);
	}

	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		return customString.regionMatches(ignoreCase, toffset, other, ooffset, len);
	}

	public boolean startsWith(String prefix, int toffset) {
		return customString.startsWith(prefix, toffset);
	}

	public boolean startsWith(String prefix) {
		return customString.startsWith(prefix);
	}

	public boolean endsWith(String suffix) {
		return customString.endsWith(suffix);
	}

	public int hashCode() {
		return customString.hashCode();
	}

	public int indexOf(int ch) {
		return customString.indexOf(ch);
	}

	public int indexOf(int ch, int fromIndex) {
		return customString.indexOf(ch, fromIndex);
	}

	public int lastIndexOf(int ch) {
		return customString.lastIndexOf(ch);
	}

	public int lastIndexOf(int ch, int fromIndex) {
		return customString.lastIndexOf(ch, fromIndex);
	}

	public int indexOf(String str) {
		return customString.indexOf(str);
	}

	public int indexOf(String str, int fromIndex) {
		return customString.indexOf(str, fromIndex);
	}

	public int lastIndexOf(String str) {
		return customString.lastIndexOf(str);
	}

	public int lastIndexOf(String str, int fromIndex) {
		return customString.lastIndexOf(str, fromIndex);
	}

	public String substring(int beginIndex) {
		return customString.substring(beginIndex);
	}

	public String substring(int beginIndex, int endIndex) {
		return customString.substring(beginIndex, endIndex);
	}

	public CharSequence subSequence(int beginIndex, int endIndex) {
		return customString.subSequence(beginIndex, endIndex);
	}

	public String concat(String str) {
		return customString.concat(str);
	}

	public String replace(char oldChar, char newChar) {
		return customString.replace(oldChar, newChar);
	}

	public boolean matches(String regex) {
		return customString.matches(regex);
	}

	public boolean contains(CharSequence s) {
		return customString.contains(s);
	}

	public String replaceFirst(String regex, String replacement) {
		return customString.replaceFirst(regex, replacement);
	}

	public String replaceAll(String regex, String replacement) {
		return customString.replaceAll(regex, replacement);
	}

	public String replace(CharSequence target, CharSequence replacement) {
		return customString.replace(target, replacement);
	}

	public String[] split(String regex, int limit) {
		return customString.split(regex, limit);
	}

	public String[] split(String regex) {
		return customString.split(regex);
	}

	public String toLowerCase(Locale locale) {
		return customString.toLowerCase(locale);
	}

	public String toLowerCase() {
		return customString.toLowerCase();
	}

	public String toUpperCase(Locale locale) {
		return customString.toUpperCase(locale);
	}

	public String toUpperCase() {
		return customString.toUpperCase();
	}

	public String trim() {
		return customString.trim();
	}

	public String strip() {
		return customString.strip();
	}

	public String stripLeading() {
		return customString.stripLeading();
	}

	public String stripTrailing() {
		return customString.stripTrailing();
	}

	public boolean isBlank() {
		return customString.isBlank();
	}

	public Stream<String> lines() {
		return customString.lines();
	}

	public String indent(int n) {
		return customString.indent(n);
	}

	public String stripIndent() {
		return customString.stripIndent();
	}

	public String translateEscapes() {
		return customString.translateEscapes();
	}

	public <R> R transform(Function<? super String, ? extends R> f) {
		return customString.transform(f);
	}

	public String toString() {
		return customString.toString();
	}

	public IntStream chars() {
		return customString.chars();
	}

	public IntStream codePoints() {
		return customString.codePoints();
	}

	public char[] toCharArray() {
		return customString.toCharArray();
	}

	public String formatted(Object... args) {
		return customString.formatted(args);
	}

	public String intern() {
		return customString.intern();
	}

	public String repeat(int count) {
		return customString.repeat(count);
	}

	public Optional<String> describeConstable() {
		return customString.describeConstable();
	}

	public String resolveConstantDesc(Lookup lookup) {
		return customString.resolveConstantDesc(lookup);
	}
	
}


class CustomStringImplementation {
	public static void main(String[] args) {
		CustomString str = new CustomString("aasjdbskjbdasdsd");
		System.out.println(str.countVowel());
	}
}

