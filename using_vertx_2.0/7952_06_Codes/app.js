var container = require("vertx/container");

container.deployModule("io.vertx~mod-web-server~2.0.0-final", {
  port: parseInt(container.env.get('MINDMAPS_PORT')) || 8080,
  
  bridge: true,
  inbound_permitted: [
    { address: 'mindMaps.list' },
    { address: 'mindMaps.save' },
    { address: 'mindMaps.delete' },
    { address_re: 'mindMaps\\.editor\\..+' },
    { address: 'com.vertxbook.svg2png' }
  ],
  outbound_permitted: [
    { address_re: 'mindMaps\\.events\\..+' }
  ]
}, 2);
container.deployModule("io.vertx~mod-mongo-persistor~2.0.0-final", {
  address: "mindMaps.persistor",
  db_name: "mind_maps"
}, 2);

container.deployVerticle('mindmaps.js', null, 3);
container.deployVerticle('mindmap_editor.js', null, 3);
container.deployModule('com.vertxbook~mod-svg2png~1.0', null, 10);
