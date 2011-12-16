jQuery.noConflict();                        
jQuery(document).ready(
function($)
{
$("#datepicker01").datepicker();
$("#datepicker01").datepicker("option", "monthNames", ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'] );
$("#datepicker01").datepicker("option", "dayNamesMin", ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa']);
$("#datepicker01").datepicker("option", "numberOfMonths", [3, 4]);
$("#datepicker01").datepicker("option", "stepMonths", 0);
$("#datepicker01").datepicker({dateFormat: 'mm/dd/yy'}).datepicker('setDate', '01/01/#{planilla$calendario.anio}');
}); 
