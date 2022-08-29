import java.util.Scanner;
class SportDesc{
enum CircumferenceUnits {
INCH, CENTIMETER
}
enum WeightUnits {
OUNCE, GRAM
}
enum SportsType {
CRICKET, VOLLEYBALL, SOCCER, BASKETBALL, NOT_UDENTIFIED
}
private CircumferenceUnits circumferenceUnit;
private WeightUnits weightUnit;
public void figureWeightAndCircumference(String descript) {
if (descript.contains("in")||descript.contains("inches")) {
circumferenceUnit = CircumferenceUnits.INCH;
} else if (descript.contains("cm")) {
circumferenceUnit = CircumferenceUnits.CENTIMETER;
}
if (descript.contains("oz")) {
weightUnit = WeightUnits.OUNCE;
} else if (descript.contains("gm")) {
weightUnit = WeightUnits.GRAM;
}
}
public SportsType returnSports(String descript) {
StringBuilder circumferenceStr = new StringBuilder();
StringBuilder weightStr = new StringBuilder();
Boolean isWhiteSpaceRead = false;
for (char ch : descript.toCharArray()) {
if (Character.isDigit(ch) || ch == '.') {
if (!isWhiteSpaceRead) {
circumferenceStr.append(ch);
} else {
weightStr.append(ch);
}
} else if (Character.isWhitespace(ch)) {
isWhiteSpaceRead = true;
}
}
figureWeightAndCircumference(descript);
float circumeference = Float.parseFloat(circumferenceStr.toString());
float weight = Float.parseFloat(weightStr.toString());
if (circumeference >= 27 && circumeference <= 28 && this.circumferenceUnit ==
CircumferenceUnits.INCH && weight >= 14 && weight <= 16 && this.weightUnit ==
WeightUnits.OUNCE) {
return SportsType.SOCCER;
} else if (circumeference >= 25.5 && circumeference <= 26.6 &&
this.circumferenceUnit == CircumferenceUnits.INCH && weight >= 9.2 && weight <=
9.9 && this.weightUnit == WeightUnits.OUNCE) {
return SportsType.VOLLEYBALL;
} else if (circumeference >= 22.4 && circumeference <= 22.9 && weight >= 140 &&
weight <= 151 && this.circumferenceUnit == CircumferenceUnits.CENTIMETER &&
this.weightUnit == WeightUnits.GRAM) {
return SportsType.CRICKET;
} else if (circumeference == 29.5 && this.circumferenceUnit ==
CircumferenceUnits.INCH && weight == 22 && this.weightUnit ==
WeightUnits.OUNCE) {
return SportsType.BASKETBALL;
} else {
return SportsType.NOT_UDENTIFIED;
}
}
}
class SportAcademy {
public static void main(String[] args) {
SportDesc sportsAcademy = new SportDesc();
Scanner sc = new Scanner(System.in);
String description = sc.nextLine();
System.out.println(sportsAcademy.returnSports(description));
}
}