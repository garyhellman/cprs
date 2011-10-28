Ext.define('EarmarkApp.model.Sponsor', {
	extend: 'Ext.data.Model',
	
	fields: [
	  {name: 'IDSPONSOR', type: 'integer'},
	  {name: 'HONORIFIC', type: 'string'},
	  {name: 'FIRSTNAME', type: 'string'},
	  {name: 'LASTNAME', type: 'string'},
	  {name: 'PARTY', type: 'string'},
	  {name: 'STATE', type: 'string'},
	  
	   {
		  name: 'FULLNAME',
		  type: 'string',
		  convert: function(value, record) {
			 return record.get('HONORIFIC') + " " + record.get('FIRSTNAME') + " " +  record.get('LASTNAME') + ' (' + record.get('STATE') + ')';  
		  }
	  }
	],
	
	setFULLNAME: function() {
   		this.set('FULLNAME',  	this.get('HONORIFIC') + " " + this.get('FIRSTNAME') + " " +  this.get('LASTNAME') + ' (' + this.get('STATE') + ')');
	},
 
	validations: [
 		{
			type: 'inclusion',  
		    field: 'PARTY', 
		    list: ['Democrat', 'Republican', 'Independent']
		},
 		{
			type: 'inclusion',    
			field: 'HONORIFIC', 
		    list: ['Senator','Representative']
		},
		{ 
			type: 'presence',
			field: 'FIRSTNAME'
		},
		{ 
			type: 'presence',
			field: 'LASTNAME'
		},
		{
			type: 'format',
			field: 'STATE',
			matcher: /^[A-Z]{2}$/
		}
	],
	hasMany: {model: 'earmark', name: 'earmarks'},
	proxy: {
		type: 'scripttag',
	    url: 'http://www.senchatraining.com/ftextjs4/webservices/sponsor.cfc?method=wsJSONP'	
	}
});