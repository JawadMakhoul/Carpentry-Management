import datetime
import configparser
from base64 import b64decode
import webbrowser
import openai
from openai.error import InvalidRequestError

def generate_image(prompt, num_image=1, size='512x512', output_format='url'):
    """
    params:
        prompt (str):
        num_image (int):
        size (str):
        output_format (str):
    """
    try:
        images = []
        response = openai.Image.create(
            prompt=prompt,
            n=num_image,
            size=size,
            response_format=output_format
        )
        if response is not None:
            if output_format == 'url':
                for image in response['data']:
                    images.append(image.url)
            elif output_format == 'b64_json':
                for image in response['data']:
                    images.append(image.b64_json)
            return {'created': datetime.datetime.fromtimestamp(response['created']), 'images': images}
        else:
            print("Response is None. Check your OpenAI account or the status of your API call.")
            return None
    except InvalidRequestError as e:
        print(e)
        return None

config = configparser.ConfigParser()
config.read('credential.ini')
API_KEY = config['openai']['APIKEY']

openai.api_key = API_KEY

SIZES = ('1024x1024', '512x512', '256x256')

# generate images (url outputs)
"""response = generate_image('cat with a book', num_image=2, size=SIZES[0])
if response is not None:
    print(response['created'])
    images = response['images']
    for image in images:
        webbrowser.open(image)
else:
    print("Failed to generate image URLs.")"""

# generate images (byte output)
# Get image description from user
image_description = input()
print("You entered: " + image_description)
# Specify the folder where you want to save the images
output_folder = "C:\\Users\\jawad\\git\\Awni-wood-work\\src\\Lib"

# Generate images (byte output)
response = generate_image(image_description, num_image=3, size=SIZES[1], output_format='b64_json')
if response is not None:
    prefix = 'demoo'
    for indx, image in enumerate(response['images']):
        # Combine the output folder path with the file name
        output_path = f"{output_folder}/{prefix}_{indx}.jpg"
        with open(output_path, 'wb') as f:
            f.write(b64decode(image))
    print(f"Images successfully saved in {output_folder}")
else:
    print("Failed to generate byte images.")

