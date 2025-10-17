def download_file(request):
    file_name = request.GET.get('file', '')
    base_directory = '/vagrant/coffeeshopsite/coffeeshop/files/'
    
    # Insecure file path construction (fix)
    file_path = os.path.normpath(os.path.join(base_directory, file_name))
    if not file_path.startswith(base_directory):
        return HttpResponse("Access denied")
    
    try:
        with open(file_path, 'rb') as f:
            response = HttpResponse(f.read(), content_type='application/octet-stream')
            response['Content-Disposition'] = f'attachment; filename="{file_name}"'
            return response
    except FileNotFoundError:
        return HttpResponse("File not found")