package net.tp.utils.classes;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.*;

import static java.lang.Long.MAX_VALUE;
import static java.lang.Long.MIN_VALUE;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNullElse;

/**
 * A date-time without a time-zone and without year in the ISO-8601 calendar system,
 * such as {@code --12-03T10:15:30}.
 * <p>
 * {@code LocalMonthDayTime} is a date-time object without year that represents a date-time without year,
 * often viewed as --month-day-hour-minute-second. Other date and time fields,
 * such as day-of-year, day-of-week and week-of-year, can also be accessed.
 * Time is represented to nanosecond precision.
 * For example, the value "3rd September at 10:15:30" can be
 * stored in a {@code LocalMonthDayTime}.
 * <p>
 * This class does not store or represent a time-zone.
 * Instead, it is a description of the date without year, combined with
 * the local time as seen on a wall clock.
 * It cannot represent an instant on the time-line without additional information
 * such as an offset or time-zone.
 *
 * @author Tommaso Pastorelli
 * @since 1.0.0
 */
public class LocalMonthDayTime {
	private final MonthDay monthDay;
	private final LocalTime localTime;

	static final int DEFAULT_LEAP_YEAR = 2024;
	static final int DEFAULT_NON_LEAP_YEAR = 2025;
	static final int HOURS_PER_DAY = 24;
	static final int MINUTES_PER_HOUR = 60;
	static final int MINUTES_PER_DAY = MINUTES_PER_HOUR * HOURS_PER_DAY;
	static final int SECONDS_PER_MINUTE = 60;
	static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
	static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;
	static final long MILLIS_PER_SECOND = 1000L;
	static final long MILLIS_PER_DAY = MILLIS_PER_SECOND * SECONDS_PER_DAY;
	static final long MICROS_PER_SECOND = 1000_000L;
	static final long MICROS_PER_DAY = MICROS_PER_SECOND * SECONDS_PER_DAY;
	static final long NANOS_PER_SECOND =  1000_000_000L;
	static final long NANOS_PER_MINUTE = NANOS_PER_SECOND * SECONDS_PER_MINUTE;
	static final long NANOS_PER_HOUR = NANOS_PER_MINUTE * MINUTES_PER_HOUR;
	static final long NANOS_PER_DAY = NANOS_PER_HOUR * HOURS_PER_DAY;

	private LocalMonthDayTime(MonthDay monthDay, LocalTime localTime) {
		this.monthDay = monthDay;
		this.localTime = localTime;
	}

	/**
	 * @return the month-day part of this date-time without year, not null
	 * @since 1.0.0
	 */
	public MonthDay getMonthDay() {
		return monthDay;
	}

	/**
	 * @return the local time part of this date-time without year, not null
	 */
	public LocalTime getLocalTime() {
		return localTime;
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from a temporal object.
	 * <p>
	 * This obtains a local date-time without year based on the specified temporal.
	 * A {@link TemporalAccessor} represents an arbitrary set of date and time information,
	 * which factory converts to an instance of {@code LocalMonthDayTime}.
	 * <p>
	 * The conversion extracts and combines the {@link LocalDate} and the
	 * {@code LocalTime} from the temporal object.
	 * Implementations are permitted to perform optimizations such as accessing
	 * those fields that are equivalent to the relevant objects.
	 * <p>
	 * This method matches the signature of the functional interface {@link TemporalQuery}
	 * allowing it to be used as a query via method reference, {@code LocalMonthDayTime::from}.
	 *
	 * @param temporalAccessor the temporal object to convert; if null current
	 * @return the local date-time; not null
	 * @throws DateTimeException if unable to convert to a {@link MonthDay} or {@link LocalTime}
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime from(TemporalAccessor temporalAccessor) {
		if (isNull(temporalAccessor)) return now();
		return new LocalMonthDayTime(MonthDay.from(temporalAccessor), LocalTime.from(temporalAccessor));
	}

	/**
	 * Checks if date-time without year is after the specified date-time  without year.
	 * <p>
	 * This checks to see if date-time without year represents a point on the
	 * local time-line after the other date-time without year.
	 * <pre>
	 *   LocalMonthDayTime a = LocalMonthDayTime.of(6, 30, 12, 00);
	 *   LocalMonthDayTime b = LocalMonthDayTime.of(7, 1, 12, 00);
	 *   a.isAfter(b) == false
	 *   a.isAfter(a) == false
	 *   b.isAfter(a) == true
	 * </pre>
	 * <p>
	 * This method only considers the position of the two date-times without years on the local time-line.
	 * It does not take into account the chronology, or calendar system.
	 *
	 * @param other the other date-time without year to compare to; if null current
	 * @param firstLeap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @param secondLeap true if the parameter year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return true if date-time without year is after the specified date-time
	 * @since 1.0.0
	 */
	public boolean isAfter(LocalMonthDayTime other, boolean firstLeap, boolean secondLeap) {
		other = requireNonNullElse(other, now());

		LocalDateTime firstDate = LocalDateTime.of(
				LocalDate.of(firstLeap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), monthDay.getDayOfMonth()),
				localTime
		);
		LocalDateTime secondDate = LocalDateTime.of(
				LocalDate.of(secondLeap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, other.getMonthDay().getMonth(), other.getMonthDay().getDayOfMonth()),
				other.getLocalTime()
		);
		return firstDate.isAfter(secondDate);
	}

	/**
	 * Checks if date-time without year is before the specified date-time without year.
	 * <p>
	 * This checks to see if date-time without year represents a point on the
	 * local time-line before the other date-time without year.
	 * <pre>
	 *   LocalMonthDayTime a = LocalMonthDayTime.of(6, 30, 12, 00);
	 *   LocalMonthDayTime b = LocalMonthDayTime.of(7, 1, 12, 00);
	 *   a.isBefore(b) == true
	 *   a.isBefore(a) == false
	 *   b.isBefore(a) == false
	 * </pre>
	 * <p>
	 * This method only considers the position of the two date-times without years on the local time-line.
	 * It does not take into account the chronology, or calendar system.
	 *
	 * @param other the other date-time without year to compare to; if null current
	 * @param firstLeap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @param secondLeap true if the parameter year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return true if date-time without year is before the specified date-time
	 * @since 1.0.0
	 */
	public boolean isBefore(LocalMonthDayTime other, boolean firstLeap, boolean secondLeap) {
		other = requireNonNullElse(other, now());

		LocalDateTime firstDate = LocalDateTime.of(
				LocalDate.of(firstLeap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), monthDay.getDayOfMonth()),
				localTime
		);
		LocalDateTime secondDate = LocalDateTime.of(
				LocalDate.of(secondLeap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, other.getMonthDay().getMonth(), other.getMonthDay().getDayOfMonth()),
				other.getLocalTime()
		);
		return firstDate.isBefore(secondDate);
	}

	/**
	 * Checks if date-time without year is equal to the specified date-time without year.
	 * <p>
	 * This checks to see if date-time without year represents the same point on the
	 * local time-line as the other date-time without year.
	 * <pre>
	 *   LocalMonthDayTime a = LocalMonthDayTime.of(6, 30, 12, 00);
	 *   LocalMonthDayTime b = LocalMonthDayTime.of(7, 1, 12, 00);
	 *   a.isEqual(b) == false
	 *   a.isEqual(a) == true
	 *   b.isEqual(a) == false
	 * </pre>
	 * <p>
	 * This method only considers the position of the two date-times without years on the local time-line.
	 * It does not take into account the chronology, or calendar system.
	 *
	 * @param other the other date-time without year to compare to; if null current
	 * @param firstLeap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @param secondLeap true if the parameter year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return true if date-time without year is equal to the specified date-time without year
	 * @since 1.0.0
	 */
	public boolean isEqual(LocalMonthDayTime other, boolean firstLeap, boolean secondLeap) {
		other = requireNonNullElse(other, now());

		LocalDateTime firstDate = LocalDateTime.of(
				LocalDate.of(firstLeap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), monthDay.getDayOfMonth()),
				localTime
		);
		LocalDateTime secondDate = LocalDateTime.of(
				LocalDate.of(secondLeap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, other.getMonthDay().getMonth(), other.getMonthDay().getDayOfMonth()),
				other.getLocalTime()
		);
		return firstDate.isEqual(secondDate);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of days subtracted.
	 *
	 * @param amountToSubtract the amount to days to subtract, may be negative
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the days subtracted; not null
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime minusDays(long amountToSubtract, boolean leap) {
		return amountToSubtract == MIN_VALUE
				? plusDays(MAX_VALUE, leap).plusDays(1, leap)
				: plusDays(-amountToSubtract, leap);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of hours subtracted.
	 *
	 * @param amountToSubtract the amount to hours to subtract, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the hours subtracted; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime minusHours(long amountToSubtract, boolean leap) {
		return amountToSubtract == MIN_VALUE
				? plusHours(MAX_VALUE, leap).plusHours(1, leap)
				: plusHours(-amountToSubtract, leap);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of minutes subtracted.
	 *
	 * @param amountToSubtract the amount to minutes to subtract, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the minutes subtracted; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime minusMinutes(long amountToSubtract, boolean leap) {
		return amountToSubtract == MIN_VALUE
				? plusMinutes(MAX_VALUE, leap).plusMinutes(1, leap)
				: plusMinutes(-amountToSubtract, leap);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of months subtracted.
	 *
	 * @param amountToSubtract the amount to months to subtract, may be negative
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the months subtracted; not null
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime minusMonths(long amountToSubtract, boolean leap) {
		return amountToSubtract == MIN_VALUE
				? plusMonths(MAX_VALUE, leap).plusMonths(1, leap)
				: plusMonths(-amountToSubtract, leap);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of nanoseconds subtracted.
	 *
	 * @param amountToSubtract the amount to nanoseconds to subtract, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the nanoseconds subtracted; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime minusNanos(long amountToSubtract, boolean leap) {
		return amountToSubtract == MIN_VALUE
				? plusNanos(MAX_VALUE, leap).plusNanos(1, leap)
				: plusNanos(-amountToSubtract, leap);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of seconds subtracted.
	 *
	 * @param amountToSubtract the amount to seconds to subtract, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the seconds subtracted; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime minusSeconds(long amountToSubtract, boolean leap) {
		return amountToSubtract == MIN_VALUE
				? plusSeconds(MAX_VALUE, leap).plusSeconds(1, leap)
				: plusSeconds(-amountToSubtract, leap);
	}
	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of weeks subtracted.
	 *
	 * @param amountToSubtract the amount to weeks to subtract, may be negative
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the weeks subtracted; not null
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime minusWeeks(long amountToSubtract, boolean leap) {
		return amountToSubtract == MIN_VALUE
				? plusWeeks(MAX_VALUE, leap).plusWeeks(1, leap)
				: plusWeeks(-amountToSubtract, leap);
	}

	/**
	 * Returns a copy of date-time with the specified amount subtracted.
	 * <p>
	 * This returns a {@code LocalMonthDayTime}, based on one, with the amount
	 * in terms of the unit subtracted. If it is not possible to subtract the amount,
	 * because the unit is not supported or for some other reason, an exception is thrown.
	 * <p>
	 * This method is equivalent to {@link #plus(long, ChronoUnit, boolean)} with the amount negated.
	 * See that method for a full description of how addition, and thus subtraction, works.
	 *
	 * @param amountToSubtract the amount of the unit to subtract from the result, may be negative
	 * @param unit the unit of the amount to subtract; not null
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalDateTimeWithoutException} based on date-time with the specified amount subtracted; not null
	 * @throws DateTimeException if the subtraction cannot be made
	 * @throws UnsupportedTemporalTypeException if the unit is not supported
	 * @throws ArithmeticException if numeric overflow occurs
	 * @since 1.0.0
	 */
	public LocalMonthDayTime minus(long amountToSubtract, ChronoUnit unit, boolean leap) {
		if (isNull(unit)) throw new NullPointerException("Unit cannot be null");
		return amountToSubtract == MIN_VALUE
				? plus(MAX_VALUE, unit, leap).plus(1, unit, leap)
				: plus(-amountToSubtract, unit, leap);
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} of the current date-time without year like {@code --09-06T10:11:41}.
	 *
	 * @return The current local date-time without year; not null
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime now() {
		return new LocalMonthDayTime(MonthDay.now(), LocalTime.now());
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from month,
	 * day, hour, minute, second and nanosecond.
	 * <p>
	 * This returns a {@code LocalMonthDayTime} with the specified month,
	 * day-of-month, hour, minute, second and nanosecond.
	 * The day must be valid for the year and month, otherwise an exception will be thrown.
	 *
	 * @param month the month-of-year to represent, from 1 (January) to 12 (December)
	 * @param day the day-of-month to represent, from 1 to 31
	 * @param hour the hour-of-day to represent, from 0 to 23
	 * @param min the minute-of-hour to represent, from 0 to 59
	 * @param sec the second-of-minute to represent, from 0 to 59
	 * @param nanoOfSec the nano-of-second to represent, from 0 to 999,999,999
	 * @return the local date-time without year; not null
	 * @throws DateTimeException if the value of any field is out of range or invalid
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime of(int month, int day, int hour, int min, int sec, int nanoOfSec) {
		return new LocalMonthDayTime(MonthDay.of(month, day), LocalTime.of(hour, min, sec, nanoOfSec));
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from month,
	 * day, hour, minute and second.
	 * <p>
	 * This returns a {@code LocalMonthDayTime} with the specified month,
	 * day-of-month, hour, minute, second and nanosecond.
	 * The day must be valid for the year and month, otherwise an exception will be thrown.
	 *
	 * @param month the month-of-year to represent, from 1 (January) to 12 (December)
	 * @param day the day-of-month to represent, from 1 to 31
	 * @param hour the hour-of-day to represent, from 0 to 23
	 * @param min the minute-of-hour to represent, from 0 to 59
	 * @param sec the second-of-minute to represent, from 0 to 59
	 * @return the local date-time without year; not null
	 * @throws DateTimeException if the value of any field is out of range or invalid
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime of(int month, int day, int hour, int min, int sec) {
		return new LocalMonthDayTime(MonthDay.of(month, day), LocalTime.of(hour, min, sec));
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from month,
	 * day, hour and minute.
	 * <p>
	 * This returns a {@code LocalMonthDayTime} with the specified month,
	 * day-of-month, hour, minute, second and nanosecond.
	 * The day must be valid for the year and month, otherwise an exception will be thrown.
	 *
	 * @param month the month-of-year to represent, from 1 (January) to 12 (December)
	 * @param day the day-of-month to represent, from 1 to 31
	 * @param hour the hour-of-day to represent, from 0 to 23
	 * @param min the minute-of-hour to represent, from 0 to 59
	 * @return the local date-time without year; not null
	 * @throws DateTimeException if the value of any field is out of range or invalid
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime of(int month, int day, int hour, int min) {
		return new LocalMonthDayTime(MonthDay.of(month, day), LocalTime.of(hour, min));
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from month,
	 * day, hour, minute, second and nanosecond.
	 * <p>
	 * This returns a {@code LocalMonthDayTime} with the specified month,
	 * day-of-month, hour, minute, second and nanosecond.
	 * The day must be valid for the year and month, otherwise an exception will be thrown.
	 *
	 * @param month the month-of-year to represent; if null the current month
	 * @param day the day-of-month to represent
	 * @param hour the hour-of-day to represent, from 0 to 23
	 * @param min the minute-of-hour to represent, from 0 to 59
	 * @param sec the second-of-minute to represent, from 0 to 59
	 * @param nanoOfSec the nano-of-second to represent, from 0 to 999,999,999
	 * @return the local date-time without year; not null
	 * @throws DateTimeException if the value of any field is out of range or invalid
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime of(Month month, int day, int hour, int min, int sec, int nanoOfSec) {
		return of(requireNonNullElse(month, LocalDate.now().getMonth()).getValue(), day, hour, min, sec, nanoOfSec);
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from month,
	 * day, hour, minute and second.
	 * <p>
	 * This returns a {@code LocalMonthDayTime} with the specified month,
	 * day-of-month, hour, minute, second and nanosecond.
	 * The day must be valid for the year and month, otherwise an exception will be thrown.
	 *
	 * @param month the month-of-year to represent; if null the current month
	 * @param day the day-of-month to represent
	 * @param hour the hour-of-day to represent, from 0 to 23
	 * @param min the minute-of-hour to represent, from 0 to 59
	 * @param sec the second-of-minute to represent, from 0 to 59
	 * @return the local date-time without year; not null
	 * @throws DateTimeException if the value of any field is out of range or invalid
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime of(Month month, int day, int hour, int min, int sec) {
		return of(requireNonNullElse(month, LocalDateTime.now().getMonth()).getValue(), day, hour, min, sec);
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from month,
	 * day, hour and minute.
	 * <p>
	 * This returns a {@code LocalMonthDayTime} with the specified month,
	 * day-of-month, hour, minute, second and nanosecond.
	 * The day must be valid for the year and month, otherwise an exception will be thrown.
	 *
	 * @param month the month-of-year to represent; if null the current month
	 * @param day the day-of-month to represent
	 * @param hour the hour-of-day to represent, from 0 to 23
	 * @param min the minute-of-hour to represent, from 0 to 59
	 * @return the local date-time without year; not null
	 * @throws DateTimeException if the value of any field is out of range or invalid
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime of(Month month, int day, int hour, int min) {
		return of(requireNonNullElse(month, LocalDateTime.now().getMonth()).getValue(), day, hour, min);
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from instant.
	 * <p>
	 * This returns a {@code LocalMonthDayTime} with the specified month,
	 * day-of-month, hour, minute, second and nanosecond.
	 * The day must be valid for the year and month, otherwise an exception will be thrown.
	 *
	 * @param instant the instant to create date-time without year from; if null the current instant
	 * @param zoneId the zone identifier to create date-time from; if null the system default zone
	 * @return the local date-time without year; not null
	 * @throws DateTimeException if the value of any field is out of range or invalid
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime of(Instant instant, ZoneId zoneId) {
		return from(LocalDateTime.ofInstant(
				requireNonNullElse(instant, Instant.now()),
				requireNonNullElse(zoneId, ZoneId.systemDefault())
		));
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from instant.
	 * <p>
	 * This returns a {@code LocalMonthDayTime} with the specified month,
	 * day-of-month, hour, minute, second and nanosecond.
	 * The day must be valid for the year and month, otherwise an exception will be thrown.
	 *
	 * @param localDate the date with year from; if null the current date
	 * @param localTime the time to create time from; if null the current time
	 * @return the local date-time without year; not null
	 * @throws DateTimeException if the value of any field is out of range or invalid
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime of(LocalDate localDate, LocalTime localTime) {
		return new LocalMonthDayTime(
				MonthDay.from(requireNonNullElse(localDate, LocalDate.now())),
				requireNonNullElse(localTime, LocalTime.now())
		);
	}

	/**
	 * Obtains an instance of {@code LocalMonthDayTime} from a text string such as {@code 09-06T10:11:57} or {@code -09-06T10:11:57} or {@code --09-06T10:11:57}.
	 *
	 * @param s The text to parse such as {@code 09-06T10:11:57}, {@code -09-06T10:11:57} or {@code --09-06T10:11:57}; if null current
	 * @return the parsed local date-time; not null
	 * @throws DateTimeParseException if the text cannot be parsed
	 * @throws StringIndexOutOfBoundsException if the text is containing a wrong number of characters
	 * @since 1.0.0
	 */
	public static LocalMonthDayTime parse(String s) {
		if (isNull(s) || s.isEmpty() || s.isBlank()) return now();

		if (s.startsWith("--"))
			return new LocalMonthDayTime(
					MonthDay.parse(s.substring(0, 7), DateTimeFormatter.ofPattern("--MM-dd")),
					LocalTime.parse(s.substring(8))
			);
		else if (s.startsWith("-"))
			return new LocalMonthDayTime(
					MonthDay.parse(s.substring(0, 6), DateTimeFormatter.ofPattern("-MM-dd")),
					LocalTime.parse(s.substring(7))
			);
		else return new LocalMonthDayTime(
				MonthDay.parse(s.substring(0, 5), DateTimeFormatter.ofPattern("MM-dd")),
				LocalTime.parse(s.substring(6))
		);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of years added.
	 * <p>
	 * This method adds the specified amount to the years field in three steps:
	 * <ol>
	 * <li>Add the input years to the year field</li>
	 * <li>Check if the resulting date would be invalid</li>
	 * <li>Adjust the day-of-month to the last valid day if necessary</li>
	 * </ol>
	 *
	 * @param amountToAdd the years to add, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the years added; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plusDays(long amountToAdd, boolean leap) {
		return new LocalMonthDayTime(
				MonthDay.from(LocalDate.of(
						leap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), getMonthDay().getDayOfMonth()).plusDays(amountToAdd)),
				localTime
		);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of hours added.
	 *
	 * @param amountToAdd the hours to add, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the hours added; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plusHours(long amountToAdd, boolean leap) {
		return plusWithOverflow(
				LocalDate.of(leap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), monthDay.getDayOfMonth()),
				amountToAdd,
				0,
				0,
				0
		);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of minutes added.
	 *
	 * @param amountToAdd the minutes to add, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the minutes added; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plusMinutes(long amountToAdd, boolean leap) {
		return plusWithOverflow(
				LocalDate.of(leap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), monthDay.getDayOfMonth()),
				0,
				amountToAdd,
				0,
				0
		);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of months added.
	 * <p>
	 * This method adds the specified amount to the years field in three steps:
	 * <ol>
	 * <li>Add the input month to the month-of-year field</li>
	 * <li>Check if the resulting date would be invalid</li>
	 * <li>Adjust the day-of-month to the last valid day if necessary</li>
	 * </ol>
	 *
	 * @param amountToAdd the months to add, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the months added; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plusMonths(long amountToAdd, boolean leap) {
		return new LocalMonthDayTime(
				MonthDay.from(LocalDate.of(leap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), getMonthDay().getDayOfMonth()).plusMonths(amountToAdd)),
				localTime
		);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of nanoseconds added.
	 *
	 * @param amountToAdd the nanoseconds to add, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the nanoseconds added; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plusNanos(long amountToAdd, boolean leap) {
		return plusWithOverflow(
				LocalDate.of(leap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), monthDay.getDayOfMonth()),
				0,
				0,
				0,
				amountToAdd
		);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of seconds added.
	 *
	 * @param amountToAdd the seconds to add, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the seconds added; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plusSeconds(long amountToAdd, boolean leap) {
		return plusWithOverflow(
				LocalDate.of(leap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), monthDay.getDayOfMonth()),
				0,
				0,
				amountToAdd,
				0
		);
	}

	/**
	 * Returns a copy of {@code LocalMonthDayTime} with the specified number of weeks added.
	 * <p>
	 * This method adds the specified amount in weeks to the days field incrementing
	 * the month and year fields as necessary to ensure the result remains valid.
	 * The result is only invalid if the maximum/minimum year is exceeded.
	 * <p>
	 * For example, --12-31 plus one week would result in --01-07.
	 *
	 * @param amountToAdd the weeks to add, may be negative
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalMonthDayTime} based on date-time without year with the weeks added; not null
	 * @throws DateTimeException if the result exceeds the supported date range
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plusWeeks(long amountToAdd, boolean leap) {
		return new LocalMonthDayTime(
				MonthDay.from(LocalDate.of(leap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), getMonthDay().getDayOfMonth()).plusWeeks(amountToAdd)),
				localTime
		);
	}
	
	private LocalMonthDayTime plusWithOverflow(LocalDate newDate, long hours, long minutes, long seconds, long nanos) {
		if ((hours | minutes | seconds | nanos) == 0)
			return new LocalMonthDayTime(MonthDay.from(newDate), localTime);
		long totDays = nanos / NANOS_PER_DAY +
				seconds / SECONDS_PER_DAY +
				minutes / MINUTES_PER_DAY +
				hours / HOURS_PER_DAY;
		long totNanos = nanos % NANOS_PER_DAY +
				(seconds % SECONDS_PER_DAY) * NANOS_PER_SECOND +
				(minutes % MINUTES_PER_DAY) * NANOS_PER_MINUTE +
				(hours % HOURS_PER_DAY) * NANOS_PER_HOUR;
		long curNoD = localTime.toNanoOfDay();
		totNanos = totNanos + curNoD;
		totDays += Math.floorDiv(totNanos, NANOS_PER_DAY);
		long newNoD = Math.floorMod(totNanos, NANOS_PER_DAY);
		LocalTime newTime = newNoD == curNoD ? localTime : LocalTime.ofNanoOfDay(newNoD);
		return new LocalMonthDayTime(MonthDay.from(newDate.plusDays(totDays)), newTime);
	}

	/**
	 * Returns an instance of {@code LocalMonthDayTime} that is the sum of the {@code LocalMonthDayTime} that you
	 * are considering and the one that you passed like a parameter.

	 * @param other the date-time without year that you want to sum to the reference one; if null current
	 * @param firstLeap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @param secondLeap true if the parameter year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalDateTimeWithoutException} based on date-time with the specified amount subtracted; not null
	 * @throws DateTimeException if the subtraction cannot be made
	 * @throws ArithmeticException if numeric overflow occurs
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plus(LocalMonthDayTime other, boolean firstLeap, boolean secondLeap) {
		other = requireNonNullElse(other, now());

		LocalDateTime firstDate = LocalDateTime.of(
				LocalDate.of(firstLeap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, monthDay.getMonth(), monthDay.getDayOfMonth()),
				localTime
		);
		LocalDateTime secondDate = LocalDateTime.of(
				LocalDate.of(secondLeap ? DEFAULT_LEAP_YEAR : DEFAULT_NON_LEAP_YEAR, other.getMonthDay().getMonth(), other.getMonthDay().getDayOfMonth()),
				other.getLocalTime()
		);
		return from(firstDate.plus(Duration.between(firstDate, secondDate.isBefore(firstDate) ? secondDate.plusYears(1) : secondDate)));
	}

	/**
	 * Returns a copy of date-time without year with the specified amount added.
	 * <p>
	 * This returns a {@code LocalMonthDayTime}, based on one, with the amount
	 * in terms of the unit added. If it is not possible to add the amount, because the
	 * unit is not supported or for some other reason, an exception is thrown.
	 * <p>
	 * Date units are added as per {@link LocalDate#plus(long, TemporalUnit)}.
	 * Time units are added as per {@link LocalTime#plus(long, TemporalUnit)} with
	 * any overflow in days added equivalent to using {@link #plusDays(long, boolean)}}.
	 *
	 * @param amountToAdd the amount of the unit to add to the result, may be negative
	 * @param unit  the unit of the amount to add; not null
	 * @param leap true if the year is a leap year and 29 days will be calculated for the month of February for the reference year
	 * @return a {@code LocalDateTime} based on date-time with the specified amount added; not null
	 * @throws DateTimeException if the addition cannot be made
	 * @throws UnsupportedTemporalTypeException if the unit is not supported
	 * @throws ArithmeticException if numeric overflow occurs
	 * @since 1.0.0
	 */
	public LocalMonthDayTime plus(long amountToAdd, ChronoUnit unit, boolean leap) {
		if (isNull(unit)) throw new NullPointerException("Unit cannot be null");

		return switch (unit) {
			case NANOS -> plusNanos(amountToAdd, leap);
			case MICROS -> plusDays(amountToAdd / MICROS_PER_DAY, leap).plusNanos((amountToAdd % MICROS_PER_DAY) * 1000, leap);
			case MILLIS -> plusDays(amountToAdd / MILLIS_PER_DAY, leap).plusNanos((amountToAdd % MILLIS_PER_DAY) * 1000_000, leap);
			case SECONDS -> plusSeconds(amountToAdd, leap);
			case MINUTES -> plusMinutes(amountToAdd, leap);
			case HOURS -> plusHours(amountToAdd, leap);
			case HALF_DAYS -> plusDays(amountToAdd / 256, leap).plusHours((amountToAdd % 256) * 12, leap); // no overflow (256 is multiple of 2)
			case DAYS -> plusDays(amountToAdd, leap);
			case WEEKS -> plusWeeks(amountToAdd, leap);
			case MONTHS -> plusMonths(amountToAdd, leap);
			case YEARS, ERAS, DECADES, MILLENNIA, FOREVER, CENTURIES -> this;
		};
	}

	/**
	 * Obtains an instance of {@link LocalDateTime} from a text string such as {@code 2024-09-06T10:11:41}.
	 *
	 * @param year The year that you want in the date; if null the current year
	 * @return The new local date-time; not null
	 * @throws NumberFormatException if the year is not a valid integer
	 * @since 1.0.0
	 */
	public LocalDateTime toLocalDateTime(Integer year) {
		return LocalDateTime.of(
				LocalDate.of(
						requireNonNullElse(year, Integer.parseInt(Year.now().toString())),
						getMonthDay().getMonth(),
						getMonthDay().getDayOfMonth()
				),
				localTime
		);
	}

	/**
	 * Obtains an instance of {@link LocalDateTime} from a text string such as {@code 2024-09-06T10:11:41}.
	 *
	 * @param year The year that you want in the date; if null the current year
	 * @return The new local date-time; not null
	 * @throws NumberFormatException if the year is not a valid integer
	 * @since 1.0.0
	 */
	public LocalDateTime toLocalDateTime(Year year) {
		return toLocalDateTime(requireNonNullElse(year, Year.now()).getValue());
	}

	/**
	 * Obtains an instance of {@code LocalDateTime}.
	 *
	 * @return The new local date-time; not null
	 * @since 1.0.0
	 */
	public LocalDateTime toLocalDateTime() {
		return toLocalDateTime((Integer) null);
	}

	/**
	 * Obtains an instance of {@link LocalDate} from a text string such as {@code 2024-09-06}.
	 *
	 * @param year The year that you want in the date; if null the current year
	 * @return The new local date-time; not null
	 * @throws NumberFormatException if the year is not a valid integer
	 * @since 1.0.0
	 */
	public LocalDate toLocalDate(Integer year) {
		return LocalDate.of(requireNonNullElse(year, Year.now().getValue()), monthDay.getMonth(), monthDay.getDayOfMonth());
	}

	/**
	 * Obtains an instance of {@link LocalDate} from a text string such as {@code 2024-09-06}.
	 * The year is the current one.
	 *
	 * @return The new local date-time; not null
	 * @throws NumberFormatException if the year is not a valid integer
	 * @since 1.0.0
	 */
	public LocalDate toLocalDate() {
		return toLocalDate(null);
	}

	/**
	 * Obtains an instance of {@link MonthDay}.
	 *
	 * @return The month-day; not null
	 * @since 1.0.0
	 */
	public MonthDay toMonthDay() { return monthDay; }

	/**
	 * Obtains an instance of {@link LocalTime}.
	 *
	 * @return The local time; not null
	 * @since 1.0.0
	 */
	public LocalTime toLocalTime() {
		return localTime;
	}

	@Override
	public String toString() {
		return monthDay + "T" + localTime;
	}
}