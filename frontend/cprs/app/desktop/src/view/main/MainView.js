Ext.define('CPRS.view.main.MainView', {
  extend: 'Ext.container.Container',
  xtype: 'mainview',
  layout: {
    type: 'border',
    padding: 5
  },
  defaults: {
    split: true
  },
  items: [
    {
      region: 'west',
      width: 220,
      xtype: 'sidebar',
      split: true,
      title: 'Menu',
      collapsible: true
    },
    {
      region: 'north',
      xtype: 'navigationheader',
      split: false
    },
    {
      region: 'center',
      plain: true,
      xtype: 'tabpanel',
      itemId: 'mainTabPanel'
    }
  ]
});
