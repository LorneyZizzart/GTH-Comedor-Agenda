var app = new Vue({
  el: '#app',
  data: {
    scanner: null,
    activeCameraId: null,
    cameras: [],
    scans: []
  },
  mounted: function () {
    var self = this;
    self.scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 5 });
    self.scanner.addListener('scan', function (content, image) {
        registrar_asistencia(content);
      //self.scans.unshift({ date: +(Date.now()), content: content });
    });
    Instascan.Camera.getCameras().then(function (cameras) {
      self.cameras = cameras;
      if (cameras.length > 0) {
        self.activeCameraId = cameras[0].id;
        self.scanner.start(cameras[0]);
      } else {
        console.error('No cameras found.');
      }
    }).catch(function (e) {
      console.error(e);
    });
  },
  methods: {
    formatName: function (name) {
      return name || '(unknown)';
    },
    selectCamera: function (camera) {
      this.activeCameraId = camera.id;
      this.scanner.start(camera);
    }
  }
});

function registrar_asistencia(codigo) {
  var id_actividad =  $("#actividad_id").val();
  
  $.post('actividad_asistencia_registra_qr.jsp',
                    {id_empleado: codigo,
                        id_actividad: id_actividad},
                    function (html) {
                        alert(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "error: " + errorThrown;
                alert(alerta);
            });
}