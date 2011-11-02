Ext.define('EarmarkApp.model.Earmark', {
	extend: 'Ext.data.Model',
	fields: [
	  {name: 'EARMARK_ID', type: 'integer'},
	  {name: 'EARMARK_DESCRIPTION', type: 'string'},
	  {name: 'ENACTED_YEAR', type: 'integer'},
	  {name: 'AGENCY_TITLE', type: 'string'},
	  {name: 'BUREAU_TITLE', type: 'string'},
	  {name: 'AMT_CONF', type: 'integer'},
	  {name: 'AMT_HC', type: 'integer'},
	  {name: 'AMT_HF', type: 'integer'},
	  {name: 'AMT_SC', type: 'integer'},
	  {name: 'AMT_SF', type: 'integer'},
	  {name: 'IDSPONSOR', type: 'integer'},
	  {name: 'IDSPENDINGCOMMITTEE', type: 'integer'},
	  {
		  name: 'AMT_HOUSE',
		  type: 'integer',
		  convert: function(value, record) {
			 return record.get('AMT_HC') + record.get('AMT_HF');  
		  }
	  },
	  {
		  name: 'AMT_SENATE',
		  type: 'integer',
		  convert: function(value, record) {
			 return record.get('AMT_SC') + record.get('AMT_SF');  
		  }
	  }
	],

	associations: [
        {
				type: 'belongsTo',
				model: 'Sponsor', 
				primaryKey: 'IDSPONSOR', 
				foreignKey: 'IDSPONSOR'
		},
        {
				type: 'belongsTo',
				model: 'SpendingCommittee', 
				primaryKey: 'IDSPENDINGCOMMITTEE', 
				foreignKey: 'IDSPENDINGCOMMITTEE'
		}
	],
	proxy: {
		type: 'scripttag',
		url: 'http://www.senchatraining.com/ftextjs4/webservices/earmark.cfc?method=wsJSONP'
	}
	
});