package com.utils.tracking;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.model.ConsignmentDTO;


public class OrderTracking
{
	public static String identifyDepartureTime(ConsignmentDTO consignment)
	{
		int day;
		LocalDate startdate=consignment.getStart_date();
		LocalTime starttime=consignment.getStart_time();
		if(checkSpecialconstraints(startdate))
		{
			consignment.setStart_date(setspecialconstraints(startdate));
			consignment.setStart_time(setConstraintTime(starttime));
		}
		else if((checkconstraint(startdate))!=0)
		{
			day=checkconstraint(startdate);
			consignment.setStart_date(setconstraintDate(startdate, day));
			consignment.setStart_time(setConstraintTime(starttime));
			
		}
		float time=getTime(consignment.getDistance(),consignment.getTravelspeed());
		if(consignment.getTravel_break()!=0)
		{
			time=getbreak(time,consignment.getTravel_break());
		}
		float minutes=time%1;
		minutes=(float)(time-Math.floor(time));
		minutes=minutes*100;
		ArrayList<String> datetime=getdatetime(starttime,time,startdate);
		LocalTime nextTime=LocalTime.parse(datetime.get(1));
		nextTime=nextTime.plus((long) minutes,ChronoUnit.MINUTES);
		String n=nextTime.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
		LocalDate d=LocalDate.parse(datetime.get(0));
		return "The parcel will reach at "+n+" (approximately)  "+d+" "+d.getDayOfWeek();
	}
	private static LocalDate setspecialconstraints(LocalDate start_date) 
	{
		
			int day=1;
			start_date=setconstraintDate(start_date, day);
			if(checkconstraint(start_date)!=0)
			{
				day=checkconstraint(start_date);
				start_date=setconstraintDate(start_date, day);				
			}
			
		
		return start_date;
	}

	private static boolean checkSpecialconstraints(LocalDate start_date)
	{
		if(start_date.isEqual(LocalDate.of(start_date.getYear(), 1, 1))||start_date.isEqual(LocalDate.of(start_date.getYear(), 8, 15))||
				start_date.isEqual(LocalDate.of(start_date.getYear(), 10, 2))||start_date.isEqual(LocalDate.of(start_date.getYear(), 1, 26)))
		{
			return true;
		}
		return false;
	}
	private static LocalTime setConstraintTime(LocalTime time)
	{
		return LocalTime.parse("06:00:00");
	}
	private static int checkconstraint(LocalDate start_date) {
		if(start_date.getDayOfWeek()==DayOfWeek.SUNDAY)
		{
			return 1;
		}
		else if(start_date.getDayOfWeek()==DayOfWeek.SATURDAY)
		{
			return 2;
		}
		return 0;
	}

	private static LocalDate setconstraintDate(LocalDate date,int day)
	{
		date=date.plus(day,ChronoUnit.DAYS);
		return date;
		
	}
	private static ArrayList<String> getdatetime(LocalTime start_time, float time, LocalDate start_date) {

		int hours=start_time.getHour();
		ArrayList<String> datetime=new ArrayList<String>();
		if(hours<12 && time<24)
		{
			start_time=getTime(start_time,time);
			datetime.add(String.valueOf(start_date));
			datetime.add(String.valueOf(start_time));
		}
		else if((hours<12 || hours>12) && time>24)
		{
			while(time>24)
			{
				start_date=start_date.plus(1,ChronoUnit.DAYS);
				if(checkSpecialconstraints(start_date))
				{
					start_date=setspecialconstraints(start_date);
					start_time=setConstraintTime(start_time);
				}
				else if((checkconstraint(start_date))!=0)
				{
					int day=checkconstraint(start_date);
					start_date=setconstraintDate(start_date, day);
					time=time+(start_time.getHour()-6);
					start_time=setConstraintTime(start_time);
					if(time<24)
					{
						break;
					}
					
				}
				start_time=start_time.plus(24,ChronoUnit.HOURS);
				time=time-24;
			}
			if(24-hours < time)
			{
				start_date=start_date.plus(1,ChronoUnit.DAYS);
				
			}
			start_time=getTime(start_time, time);
			datetime.add(String.valueOf(start_date));
			datetime.add(String.valueOf(start_time));
		}
		else if(hours>12 && time<24)
		{
			if(24-hours < time)
			{
				start_date=start_date.plus(1,ChronoUnit.DAYS);
				if(checkSpecialconstraints(start_date))
				{
					start_date=setspecialconstraints(start_date);
					start_time=setConstraintTime(start_time);
				}
				else if((checkconstraint(start_date))!=0)
				{
					int day=checkconstraint(start_date);
					time=time-(24-hours);
					start_date=setconstraintDate(start_date, day);
					start_time=setConstraintTime(start_time);
					
					
				}
				
			}
			start_time=getTime(start_time, time);
			datetime.add(String.valueOf(start_date));
			datetime.add(String.valueOf(start_time));
		}
		
		return datetime;
	}


	

	private static LocalTime getTime(LocalTime start_time,float time) {
		start_time=start_time.plus((long)time,ChronoUnit.HOURS);
		return start_time;
	}


	private static float getbreak(float time, int breaktime) {
		if(breaktime<time)
		{
			int cal=(int)time/breaktime;
			time+=cal;
		}
		return time;
	}


	private static float getTime(int distance, int travelspeed)
	{
		return (float)distance/(float)travelspeed;
	}

}
