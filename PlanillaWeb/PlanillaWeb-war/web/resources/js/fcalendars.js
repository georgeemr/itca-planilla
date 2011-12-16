
function highlightCalendar(specialDays, date, cssClass)
{
var d = date.getDate();
var m = date.getMonth() + 1;
var y = date.getFullYear();
if (specialDays[y] && specialDays[y][m] && specialDays[y][m][d])
    {
    var s = specialDays[y][m][d];
    return [ true, cssClass, '' ];
    }
return [ true, '' ]; // no change
}

function bindEventsHighlights()
{
jQuery(".hasDatepicker").datepicker("option", "beforeShowDay", function (date) { return highlightCalendar(specialDays, date, 'feriados'); });
}